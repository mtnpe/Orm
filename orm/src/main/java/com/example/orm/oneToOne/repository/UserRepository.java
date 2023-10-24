package com.example.orm.oneToOne.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.orm.oneToOne.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findById(long id);
	
}
