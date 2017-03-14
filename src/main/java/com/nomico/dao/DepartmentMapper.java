package com.nomico.dao;

import com.nomico.model.Department;
import com.nomico.vo.DepartmentVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMapper {
	public   int deleteByPrimaryKey(String id);

	public   int insert(Department record);

	public   int insertSelective(Department record);

	public   Department selectByPrimaryKey(String id);
	
	public   List<Department> selectAll(@Param("v") DepartmentVo v);

	public  int updateByPrimaryKeySelective(Department record);

	public  int updateByPrimaryKey(Department record);
    public  List<Department>     selectAll1();
	public int selectCount(@Param("v") DepartmentVo v);
}