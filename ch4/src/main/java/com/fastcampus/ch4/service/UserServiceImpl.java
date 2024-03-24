package com.fastcampus.ch4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastcampus.ch4.dao.UserDao;
import com.fastcampus.ch4.domain.UserDto;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;
	
	@Override
	public String join(UserDto userDto) throws Exception {
		// 중복체크
		/*
		UserDto userDto2 = userDao.selectUser(userDto.getId());
		if(userDto2.getId() != null) {
			throw new RuntimeException(userDto2.getId() + "는 이미 있습니다.");
		}
		*/
		
		// 저장
		int rowCnt = userDao.insertUser(userDto);
		
		return "SUCCESS";
	}

	@Override
	public UserDto search(String id) throws Exception {
		return userDao.selectUser(id);
	}

}
