package com.example.ums.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ums.entity.User;
import com.example.ums.service.UserService;
import com.example.ums.util.ResponseStructure;

//@Controller
//@ResponseBody
@RestController
public class UserController {
	
	private final UserService userService;
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	@PostMapping("/save-user")
  public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
	  user=userService.saveUser(user);
//	  return ResponseStructure.create(HttpStatus.CREATED.value(),"User Created", user);
	  return ResponseEntity.status(HttpStatus.CREATED).body(ResponseStructure.create(HttpStatus.CREATED.value(),"User Created", user));
	  
  }
	@GetMapping("/find-user")
	public ResponseEntity<ResponseStructure<User>> findUser(@RequestParam int userId) {
		User user=userService.findUser(userId);
		return ResponseEntity.status(HttpStatus.CREATED).body(ResponseStructure.create(HttpStatus.CREATED.value(),"User Created", user));
		
	}
	
	@GetMapping("/find-all")
	public ResponseEntity<ResponseStructure<List<User>>> findAllUsers() {
	    List<User> users = userService.findAllUsers();
//	    if (users.isEmpty()) {
//	        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ResponseStructure.create(HttpStatus.NO_CONTENT.value(), "No Users Found", users));
//	    }
	    return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.create(HttpStatus.OK.value(), "Users Retrieved Successfully", users));
	}
	
	@DeleteMapping("/delete-user")
	public ResponseEntity<ResponseStructure<User>>  deleteUser(@RequestParam int userId) {
		User user=userService.deleteUser(userId);
		return ResponseEntity.status(HttpStatus.CREATED).body(ResponseStructure.create(HttpStatus.CREATED.value(),"User Created", user));
	}
	
	@PutMapping("/update-user")
	public ResponseEntity<ResponseStructure<User>>  updateUser(@RequestBody User user) {
		user=userService.updateUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(ResponseStructure.create(HttpStatus.CREATED.value(),"User Created", user));
	}
	
	@GetMapping("/find-userByName")
	public ResponseEntity<ResponseStructure<User>> findByUserName(@RequestParam String username) {
		User user=userService.findByUserName(username);
		return ResponseEntity.status(HttpStatus.CREATED).body(ResponseStructure.create(HttpStatus.CREATED.value(),"User Created", user));
		
	}
	
//	@DeleteMapping("/delete-userByName")
//	public ResponseEntity<ResponseStructure<User>> deleteByName(@RequestParam String username){
//		User user=userService.deleteUserByName(username);
//		return ResponseEntity.status(HttpStatus.CREATED).body(ResponseStructure.create(HttpStatus.CREATED.value(),"User Delete", user));
//	}

}
