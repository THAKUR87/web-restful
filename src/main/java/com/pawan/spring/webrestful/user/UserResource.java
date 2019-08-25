package com.pawan.spring.webrestful.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
	
	@Autowired
	UserDaoService service;

	//GET /users
	//findAllUsers
	@GetMapping("/users")
	public List<User> findAllUsers(){
		return service.findAll();
	}
	
	//POST /users/user
	//createUser
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	//GET /user/{id}
	//getuserByid
	@GetMapping("/users/{id}")
	public EntityModel<User> getUserByid(@PathVariable int id) {
		User user =  service.findOne(id);
		
		if (user == null) {
			throw new UserNotfoundException("User  Id  not found:" + id);
		}
		
		EntityModel<User> model = new EntityModel<>(user);
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findAllUsers());
		model.add(linkTo.withRel("all-users"));
		return model;
	}
	
	
	@DeleteMapping("/users/{id}")
	public void deleteUserByid(@PathVariable int id) {
		User user =  service.deleteById(id);
		
		if (user == null) {
			throw new UserNotfoundException("User  Id  not found:" + id);
		}
	}
	
}
