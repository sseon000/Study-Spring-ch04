package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.domain.*;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
    private SqlSession session;
    private static String namespace = "com.fastcampus.ch4.dao.UserMapper.";

	@Override
	public UserDto selectUser(String id) throws Exception {
		return session.selectOne(namespace+"select", id);
	}

	@Override
	public int insertUser(UserDto user) throws Exception {
		return session.insert(namespace+"insert", user);
	}
	
	@Override
	public int deleteUser(String id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int updateUser(UserDto user) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int count() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		
	}
    
}