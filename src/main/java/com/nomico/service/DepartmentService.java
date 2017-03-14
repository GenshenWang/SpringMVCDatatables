package com.nomico.service;

import com.nomico.model.Department;
import com.nomico.vo.DepartmentVo;

import java.util.List;

public interface DepartmentService {
	public   List<Department> selectAll(DepartmentVo v);
	public   void deleteByPrimaryKey(String id) throws Exception;
	public   void insertSelective(Department record) throws Exception;
	public   Department selectByPrimaryKey(String id);
	public  void updateByPrimaryKeySelective(Department record) throws Exception;
	public  List<Department>     selectAll1();
	public int selectCount(DepartmentVo v);
}
