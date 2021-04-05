package com.localmicroservicedemo.user.VO;

import com.localmicroservicedemo.user.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseObject {

	private User user;
	private Department department;
}
