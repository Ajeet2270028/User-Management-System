package com.example.ums.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.ums.entity.User;
import com.example.ums.exception.UserNotFoundByNameException;
import com.example.ums.exception.UserNotFoundException;
import com.example.ums.repository.UserRepository;
@Service
public class UserService {
   private final UserRepository userRepository;
	public UserService(UserRepository userRepository) {
	super();
	this.userRepository = userRepository;
}
	
	public User saveUser(User user) {
		return userRepository.save(user);
		
	}

	public User findUser(int userId) {
		return userRepository.findById(userId).orElseThrow(()->new UserNotFoundException("failed to find the user"));
	}
	
	public List<User> findAllUsers() {
	    return userRepository.findAll();
	}

	public User deleteUser(int userId) {
		return userRepository.findById(userId).map(user->{userRepository.delete(user);
		return user;
		}).orElseThrow(()-> new UserNotFoundException("failed to find the user"));
		
//           Optional<User> optional =UserRepository.findById(userId);
//	   if(optional.isPresent()) {
//		   User user=optional.get();
//		userRepository.delete(user);
//		return user;
//	   }else {
//		   throw new UserNotFoundException("failed to find the user");
//	   }
	}

	public User updateUser(User user) {
		//return userRepository.findById(user.getUserId()).map(userRepository::save).orElseThrow();
		
		Optional<User> optional=userRepository.findById(user.getUserId());
		
		if(optional.isPresent()) {
			return userRepository.save(user);
		}else {
//			throw new NoSuchElementException("no such found with the given userId");
		throw new UserNotFoundException("failed to find the User");
		}
	}

	public User findByUserName(String username) {
		return userRepository.findByUserName(username).orElseThrow(()-> new UserNotFoundByNameException("failed to find the user by name") );
	}

//	public User deleteUserByName(String username) {
//		
//		return UserRepository.findByUserName(username).orElseThrow(()->new UserNotFoundByNameException("failed to find the user by name"));
//	}
	
}
