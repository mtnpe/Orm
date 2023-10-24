package com.example.orm.oneToOne.controller;

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

import com.example.orm.oneToOne.entities.User;
import com.example.orm.oneToOne.service.UserService;

@RestController
public class UserAddressController {
	
	@Autowired
    private UserService userService;

    @GetMapping(path = "/users")
    @ResponseStatus(code = HttpStatus.OK)
    public List<User> getUsers() {
    	return userService.getAllUser();       
    }
    
    @PostMapping(path = "/create-user")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createUser(@RequestBody User user) {
    	 userService.addUser(user);
    }
      
    @DeleteMapping(path = "/delete-user/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable int id) {
    	userService.deleteUser(id);
    }
    
    @PutMapping(path = "/update-user/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void update(@PathVariable long id,@RequestBody User user) {
    	userService.updateUser(id,user);
    }
    
}
