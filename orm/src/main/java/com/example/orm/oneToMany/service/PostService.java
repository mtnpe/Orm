package com.example.orm.oneToMany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.orm.oneToMany.entities.Post;
import com.example.orm.oneToMany.repository.PostRepository;

@Service
public class PostService {
	@Autowired
    private PostRepository postRepository;
	
	
	public List<Post> getPost(){
		return postRepository.findAll();
	}
	
	public void addPost(Post post) {
		postRepository.save(post);
	}
	
	public void deletePost(int id) {		
		postRepository.deleteById(id);
	}
	
	public void updatePost(int id, Post post) {
		Post newPost = postRepository.findById(id);
		newPost.setTitle(post.getTitle());
		newPost.setDescription(post.getDescription());
		postRepository.save(newPost);
	}
}
