package com.example.demoheroku.entities.repository;

import com.example.demoheroku.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
