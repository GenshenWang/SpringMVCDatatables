package com.nomico.dao;

import com.nomico.model.User;

import java.util.List;

public interface UserMapper {
	public   int deleteByPrimaryKey(String id);

	public  int insert(User record);

	public  int insertSelective(User record);

	public User selectByPrimaryKey(String id);

	public User selectByPramater(User record);
	
	public  int updateByPrimaryKeySelective(User record);
	
	public  int updateByPrimaryKey(User record);
	
	
	public   List<User> selectAll(User user);
}