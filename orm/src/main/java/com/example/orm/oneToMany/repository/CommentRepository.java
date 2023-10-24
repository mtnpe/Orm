package com.example.orm.oneToMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.orm.oneToMany.entities.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
	Comment findById(int id);
}
