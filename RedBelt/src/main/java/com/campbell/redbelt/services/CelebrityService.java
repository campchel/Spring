package com.campbell.redbelt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campbell.redbelt.models.Celebrity;
import com.campbell.redbelt.repositories.CelebrityRepository;


@Service
public class CelebrityService {
	@Autowired
	private CelebrityRepository celebrityRepo;
	
	// Find All
	public List<Celebrity> allCelebrities() {
		return celebrityRepo.findAll();
	}
	
	
	// Find One
	public Celebrity oneCelebrity(Long id) {
		Optional<Celebrity> optionalCelebrity = celebrityRepo.findById(id);
		if (optionalCelebrity.isPresent()) {
			return optionalCelebrity.get();
		} else {
			return null;
		}
	}
	
	// Create
		public Celebrity createCelebrity(Celebrity newCelebrity) {
			return celebrityRepo.save(newCelebrity);
		}
		
	
	// Update 
		public Celebrity updateCelebrity(Celebrity updatedCelebrity) {
			return celebrityRepo.save(updatedCelebrity);
		}
		
		
		// Delete 
		public void deleteCelebrityById(Long id) {
			celebrityRepo.deleteById(id);
		}
}

