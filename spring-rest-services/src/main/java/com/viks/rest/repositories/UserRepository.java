package com.viks.rest.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.viks.rest.repositories.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

}
