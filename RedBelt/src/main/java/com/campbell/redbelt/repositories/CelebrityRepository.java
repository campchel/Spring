package com.campbell.redbelt.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.campbell.redbelt.models.Celebrity;

@Repository
public interface CelebrityRepository extends CrudRepository<Celebrity, Long>{
	List<Celebrity> findAll();
}

