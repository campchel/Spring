package com.campbell.loginandreg.repositories;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.campbell.loginandreg.models.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    // create findByEmail
	Optional<User> findByEmail(String email);
}
