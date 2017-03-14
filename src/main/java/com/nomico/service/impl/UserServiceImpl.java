package com.nomico.service.impl;

import com.nomico.dao.UserMapper;
import com.nomico.model.User;
import com.nomico.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl  implements UserService {

 @Autowired
 private UserMapper userMapper;
	
	public User selectByPramater(User record) {
		return userMapper.selectByPramater(record);
	}

	public List<User> selectAll(User user) {
		return userMapper.selectAll(user);
	}

	public void insertSelective(User record) throws Exception {

		if(1!=userMapper.insertSelective(record)){
			throw new Exception();
		}
		
	}

	public void updateByPrimaryKeySelective(User record) throws Exception {
		  if(1!=userMapper.updateByPrimaryKeySelective(record)){
		    	throw new Exception();
		    }
	}

	public User selectByPrimaryKey(String id) {
		return userMapper.selectByPrimaryKey(id);
	}

}
