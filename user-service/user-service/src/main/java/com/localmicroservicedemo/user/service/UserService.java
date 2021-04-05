package com.localmicroservicedemo.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.localmicroservicedemo.user.VO.Department;
import com.localmicroservicedemo.user.VO.ResponseObject;
import com.localmicroservicedemo.user.entity.User;
import com.localmicroservicedemo.user.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RestTemplate restTemplate;

	public User saveUser(User user) {
		log.info("Inside saveUser of UserService");
		return userRepository.save(user);
	}

	public ResponseObject findUserWIthDepartment(Long userId) {
		log.info("Inside findUserWIthDepartment of UserService");

		ResponseObject responseObject = new ResponseObject();
		User user = new User();
		
		Optional<User> users = userRepository.findById(userId);
		if (users.isPresent())
			user = users.get();

		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(),
				Department.class);

		responseObject.setUser(user);
		responseObject.setDepartment(department);
		return responseObject;
	}

}
