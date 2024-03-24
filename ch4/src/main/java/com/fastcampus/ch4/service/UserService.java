package com.fastcampus.ch4.service;

import com.fastcampus.ch4.domain.*;

import java.util.*;

public interface UserService {
    String join(UserDto userDto) throws Exception;
    UserDto search(String id) throws Exception;
}