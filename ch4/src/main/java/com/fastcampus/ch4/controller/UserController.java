package com.fastcampus.ch4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fastcampus.ch4.domain.UserDto;
import com.fastcampus.ch4.service.UserService;

@RestController
@RequestMapping("/register")
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping("/add")
	public ResponseEntity<String> join(@RequestBody UserDto userDto) throws Exception {
		
		/*
		userDto.setId("qwer");
		userDto.setPwd("qwer");
		userDto.setName("qwer");
		userDto.setEmail("qwer@qwer.com");
		userDto.setBirth(new java.sql.Date(userDto.getBirth().getTime()));
		userDto.setSns("fb");
		*/
		
		String result = userService.join(userDto);
		
		return ResponseEntity.ok().body("회원가입이 성공 했습니다.");
	}
}
