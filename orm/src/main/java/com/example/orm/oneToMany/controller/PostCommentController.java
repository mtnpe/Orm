package com.example.orm.oneToMany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.orm.oneToMany.entities.Comment;
import com.example.orm.oneToMany.entities.Post;
import com.example.orm.oneToMany.service.CommentService;
import com.example.orm.oneToMany.service.PostService;

@RestController
public class PostCommentController {
	@Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;
    
    @GetMapping(path = "/list-post")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Post> getPost(){
    	return postService.getPost();
    }
    
    @GetMapping(path = "/list-comment")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Comment> getComment(){
    	return commentService.getComment();
    }
    
    @PostMapping(path = "/create-post")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addPost(@RequestBody Post post) {
    	postService.addPost(post);
    }
    
    @PostMapping(path = "/create-comment")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addComment(@RequestBody Comment comment) {
    	commentService.addComment(comment);
    }
    
    @DeleteMapping(path = "/delete-post/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable int id) {
    	postService.deletePost(id);
    }
    
    @DeleteMapping(path = "/delete-comment/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable int id) {
    	commentService.deleteComment(id);
    }
    
    @PutMapping(path = "/update-post/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void updatePost(@PathVariable int id, @RequestBody Post post) {
    	postService.updatePost(id,post);
    }
    
    @PutMapping(path = "/update-comment/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void updateComment(@PathVariable int id, @RequestBody Comment comment) {
    	System.out.println(comment.getAuthor());
    	commentService.updateComment(id, comment);
    }
    
}
