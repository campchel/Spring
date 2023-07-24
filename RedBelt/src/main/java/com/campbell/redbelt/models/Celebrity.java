package com.campbell.redbelt.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


//1. Attributes
//- required fields: form input data
@Entity
@Table(name="celebrities")
public class Celebrity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	
	@NotEmpty(message="Name is required!")
    @Size(min=1, message="Name must not be blank!")
    private String name;
	
	@NotEmpty(message="Details are required!")
    @Size(min=1, max=300, message="Details may not be blank!")
    private String details;
	
	// Adding One to Many Relationship
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="users_id")
	private User owner;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
			

		  
	 // 2. zero-argument constructors "()"
    // 3. getters/setters
	public Celebrity(String name, String details) {
	this.name = name;
	this.details = details;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
		
	public Celebrity() {

	}	
		
		
	@PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	@PreUpdate
		protected void onUpdate(){
			this.updatedAt = new Date();
	     }
	
}

