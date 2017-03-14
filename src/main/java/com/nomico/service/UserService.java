package com.nomico.service;

import com.nomico.model.User;

import java.util.List;

public interface UserService {

	public   List<User> selectAll(User user);
	public User selectByPramater(User record);
	public void insertSelective(User record) throws Exception;
	public void updateByPrimaryKeySelective(User record) throws Exception;
	public User selectByPrimaryKey(String id);
	
	
	
	
	
}
