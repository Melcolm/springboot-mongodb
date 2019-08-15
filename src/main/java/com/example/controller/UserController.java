package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.repository.UserRepository;
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;
    
    @RequestMapping() 
    public List<User> read() {
        List<User> a = userRepository.findAll();
        
		return a;
        
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User create(@RequestBody User user) {
        userRepository.save(user);
        
        User a = userRepository.findOne(user.getId().toString());
        return a; 
        
    }

    @RequestMapping(value = "/{id}") 
    public User read(@PathVariable String id) {
        return userRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody User user) {
        userRepository.save(user);
    }
  
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE) 
    public String delete(@PathVariable String id) {
        userRepository.delete(id);
       
        return "{}";
    }

}