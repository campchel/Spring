package com.campbell.redbelt.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.campbell.redbelt.models.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    // create findByEmail
	Optional<User> findByEmail(String email);
}