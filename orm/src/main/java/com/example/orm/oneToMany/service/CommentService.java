package com.example.orm.oneToMany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.orm.oneToMany.entities.Comment;
import com.example.orm.oneToMany.repository.CommentRepository;

@Service
public class CommentService {
	@Autowired
    private CommentRepository commentRepository;
		
	public List<Comment> getComment(){
		return commentRepository.findAll();
	}
	
	public void addComment(Comment comment) {
		commentRepository.save(comment);
	}
	
	public void deleteComment(int id) {
		commentRepository.deleteById(id);
	}
	
	public void updateComment(int id, Comment comment) {
		Comment newComment = commentRepository.findById(id);
		newComment.setAuthor(comment.getAuthor());
		newComment.setContent(comment.getContent());
		commentRepository.save(newComment);
	}
}
