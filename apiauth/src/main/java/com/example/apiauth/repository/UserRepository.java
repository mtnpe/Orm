package com.example.apiauth.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.apiauth.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
  Optional<User> findByUsername(String username);
}
