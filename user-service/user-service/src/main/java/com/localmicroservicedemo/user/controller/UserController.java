package com.localmicroservicedemo.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.localmicroservicedemo.user.VO.ResponseObject;
import com.localmicroservicedemo.user.entity.User;
import com.localmicroservicedemo.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		log.info("Inside saveUser of UserController");
		return userService.saveUser(user);
	}

	@GetMapping("/{userId}")
	public ResponseObject findUserWIthDepartment(@PathVariable Long userId) {
		log.info("Inside findUserWIthDepartment of UserController");
		return userService.findUserWIthDepartment(userId);
	}
}
