package com.nomico.service.impl;

import com.nomico.dao.DepartmentMapper;
import com.nomico.model.Department;
import com.nomico.service.DepartmentService;
import com.nomico.vo.DepartmentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

@Autowired
private DepartmentMapper departmentMapper;
	

 	public int selectCount(DepartmentVo v){
 		
 		return departmentMapper.selectCount(v);
 	}
	public List<Department> selectAll(DepartmentVo v) {
		return departmentMapper.selectAll(v);
	}

	public void insertSelective(Department record) throws Exception {
		if(1!=departmentMapper.insertSelective(record)){
			throw new Exception();
		}	
		
	}

	public void deleteByPrimaryKey(String id) throws Exception {
		if(1!=departmentMapper.deleteByPrimaryKey(id)){
			throw new Exception();
		}	
		
	}

	public void updateByPrimaryKeySelective(Department record) throws Exception {
		if(1!=departmentMapper.updateByPrimaryKeySelective(record)){
			throw new Exception();
		}			
	}

	public Department selectByPrimaryKey(String id) {
		return departmentMapper.selectByPrimaryKey(id);
	}
	public  List<Department>     selectAll1(){
		return departmentMapper.selectAll1();
	}
}
