package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	//getting all users
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	//create user rest api
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	//get user by id using rest api
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserByID(@PathVariable int id){
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not exists with id: "+id));
		return ResponseEntity.ok(user);
	}
	
	//update user by id using rest api
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id , @RequestBody User userDetails){
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not exists with id: "+id));

		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setRole(userDetails.getRole());
		user.setEmailID(userDetails.getEmailID());
		user.setPassword(userDetails.getPassword());
		user.setBookQuota(userDetails.getBookQuota());
		user.setUtilizedQuota(userDetails.getUtilizedQuota());
		User updatedUser = userRepository.save(user);
		return ResponseEntity.ok(updatedUser);
	}
	
	//delete user rest api
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable int id){
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not exists with id: "+id));
		userRepository.delete(user);
		Map<String , Boolean > response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	

	
	//get user by email and password using rest api
	@GetMapping("/users/{email}/{password}")
	public  User getUserByEmailPwd(@PathVariable String email,@PathVariable String password){
		System.out.println(email+password);
		List <User> users = userRepository.findAll();
		for(User user : users) {
			if(user.getEmailID().equals(email) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}
	
}
