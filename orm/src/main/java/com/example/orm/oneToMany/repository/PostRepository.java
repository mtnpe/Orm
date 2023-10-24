package com.example.orm.oneToMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.orm.oneToMany.entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{
	Post findById(int id);
}
