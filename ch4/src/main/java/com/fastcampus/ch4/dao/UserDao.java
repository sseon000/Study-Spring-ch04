package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.domain.*;

public interface UserDao {
    UserDto selectUser(String id) throws Exception;
    int deleteUser(String id) throws Exception;
    int insertUser(UserDto user) throws Exception;
    int updateUser(UserDto user) throws Exception;
    int count() throws Exception;
    void deleteAll() throws Exception;
}