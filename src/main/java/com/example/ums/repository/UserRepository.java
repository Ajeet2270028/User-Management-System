package com.example.ums.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ums.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	   @Query("SELECT u FROM User u where u.userName=:username")
	   Optional<User> findByUserName(String username);
	   
//	   @Query("Delete from User where userName=:username")
//	   Optional<User> deleteByName(String username);
	   
//	   Optional<User> findByUserNameandpassword();
}
