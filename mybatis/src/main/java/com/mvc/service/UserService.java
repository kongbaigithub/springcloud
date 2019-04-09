package com.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.mapper.UserMapper;
import com.mvc.model.User;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public List<User> queryList(){
		return userMapper.queryList();
	}
}
