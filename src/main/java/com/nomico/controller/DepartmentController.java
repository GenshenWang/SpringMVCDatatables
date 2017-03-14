package com.nomico.controller;

import java.io.IOException;
import java.io.Serializable;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nomico.model.Department;
import com.nomico.service.DepartmentService;
import com.nomico.util.*;
import com.nomico.vo.DepartmentVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Controller
public class DepartmentController implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2458564682310366177L;
	@Autowired
	private DepartmentService departmentService;
	@RequestMapping("department/list")
	public ModelAndView getList(@RequestParam(value="page",required=false)String page, Department dep, HttpServletRequest request){
		
		ModelAndView model=new ModelAndView();
		
		if(null!=dep){
			if(StringUtils.isNotBlank(dep.getDeptname())){
				dep.setDeptname("%"+dep.getDeptname()+"%");
			}
		}
		
		 if(StringUtil.isEmpty(page)){
			 page="1";
			}		 
		int pageNum= Integer.parseInt(page);  //把页面传过来的页码转成整型
        //pageNum  当前传过来的页码              15代表每页显示多少条
		PageHelper.startPage(pageNum,15);
		List<Department> list=	null;
				//departmentService.selectAll(dep);
		PageInfo pageinfo=new PageInfo(list);
		String targetUrl=   PageUtil.getPage("list", pageinfo,1);   //log/loglist  要跳转的url   0  使用文字分页   1  使用bootstrap按钮分页
		model.addObject("list",list);
		model.addObject("modeName", "部门管理");
		model.addObject("pageCode", targetUrl);
		model.addObject("total", pageinfo.getTotal());
		model.addObject("mainPage", "department/list.jsp");
		model.setViewName("main");
		return model;
	}
	@RequestMapping(value="user/listjson1")
	public ModelAndView  listjson1(HttpServletRequest request){
		ModelAndView model=new ModelAndView();
		model.addObject("mainPage", "department/listjson.jsp");
		model.setViewName("main");
		return model;
	
	}
	@RequestMapping(value="dept/list",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object>  listjson(DepartmentVo v, HttpServletRequest request){
		//循坏输出request里面的参数和值
//		Enumeration rnames=request.getParameterNames();
//		for (Enumeration e = rnames ; e.hasMoreElements() ;) {
//		         String thisName=e.nextElement().toString();
//		        String thisValue=request.getParameter(thisName);
//		        System.out.println(thisName+"-------"+thisValue);
//		}
//		String state=(String) request.getAttribute("state");
		 //System.out.println(state);
		 Map<String, Object> map = new HashMap<String, Object>();
//		 if(StringUtils.isNotBlank(state)){
//			 System.out.println(state);
//			 v.setState(Integer.valueOf(state));
//		 }
		 if(StringUtils.isNotBlank(v.getDeptname())){
			 v.setDeptname("%"+v.getDeptname()+"%");
		 }
	    int count=	 departmentService.selectCount(v);
		List<Department> list=	departmentService.selectAll(v);
//		map.put("iTotalRecords", count);
//	    map.put("iTotalDisplayRecords", count);
		map.put("recordsTotal", count);
	    map.put("recordsFiltered", count);
	    map.put("aaData", list);
	  //  map.put("sSortDir_0","asc");
	  //  map.put("pageDisplayLength", Integer.valueOf(v.getLength()));
		return map;
	}
	@RequestMapping("department/addjsp")
	public ModelAndView addjsp(){
		ModelAndView model=new ModelAndView();
		
		model.addObject("mainPage", "department/save.jsp");
		model.addObject("modeName", "添加部门");
		model.setViewName("main");
		
		
		return model;
	}
	@RequestMapping("department/editdep")
	public ModelAndView editjsp(HttpServletRequest request){
		ModelAndView model=new ModelAndView();
		
	String id=	request.getParameter("id");
		if(StringUtils.isNotBlank(id)){
			Department dep=	departmentService.selectByPrimaryKey(id);
			if(null!=dep){
				model.addObject("dep", dep);
			}else{
				System.out.println("部门编号不存在");
			}
		
		}
		model.addObject("mainPage", "department/edit.jsp");
		model.addObject("modeName", "修改部门信息");
		model.setViewName("main");
		return model;
	}
	@RequestMapping("department/save")
	public String insert(Department dep,HttpServletRequest request){
		dep.setId(GetUuid.getUUID());
		dep.setCreatetime(new Date());
		dep.setState(1);
		dep.setCreateip(GetIp.getIpAddr(request));
		try {
			departmentService.insertSelective(dep);
			
		} catch (Exception e) {
			System.out.println("插入失败");
		}
		
	return "redirect:/department/list.do";	
	}
	
	
	
	
	@RequestMapping("department/updatedep")
	public String updatedep(Department dep,HttpServletRequest request){
	//	dep.setId(GetUuid.getUUID());
		dep.setCreatetime(new Date());
		dep.setCreateip(GetIp.getIpAddr(request));
		try {
			departmentService.updateByPrimaryKeySelective(dep);
			
		} catch (Exception e) {
			System.out.println("部门保存失败");
		}
		
	return "redirect:/department/list.do";	
	}
	
	//@RequestMapping(value="department/delete",produces="text/html;charset=UTF-8")
	@RequestMapping(value="department/delete")
	@ResponseBody
	public Map<String, Object> delete(Department dep,HttpServletRequest request){
		Map<String, Object> map=new HashMap<String, Object>();
		dep.setOvertime(new Date());
		dep.setState(2);
		dep.setOverip(GetIp.getIpAddr(request));
		try {
			departmentService.updateByPrimaryKeySelective(dep);
			map.put("code",1);
		} catch (Exception e) {
			System.out.println("删除失败");
			map.put("code",2);
			map.put("errorInfo", "删除失败");
		}
		
	return map;	
	}
	@RequestMapping("department/export")
	public void exportcsv(HttpServletRequest request,HttpServletResponse response){
	     SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	     List exportData = new ArrayList<Map>();
		List<Department> list= departmentService.selectAll1();
		if(list!=null){
			for (Department d:list) {
				 Map<String, String> row = new LinkedHashMap<String, String>();
				 row.put("1", d.getId());
				 row.put("2", d.getDeptname());
				 if(d.getState()==1){
					 row.put("3", "有效");
				 }else if(d.getState()==2){
					 row.put("3", "无效"); 
				 }else{
					 row.put("3", "未知标示"); 
				 }
				 row.put("4", d.getRemark());
				 row.put("5",  f.format(d.getCreatetime()));
				 exportData.add(row);
			}
			   LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		        map.put("1", "id");
		        map.put("2", "部门名称");
		        map.put("3", "状态");
		        map.put("4", "备注");
		        map.put("5", "创建时间");
		        String fileName=String.valueOf("部门"+new Date().getTime());
		        try {
		            response.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(fileName, "UTF-8")+".csv");
		            response.setContentType("application/csv");
		        	//response.setContentType("application/x-msdownload");  txt
		            response.setCharacterEncoding("UTF-8");
		            
		            String agent = request.getHeader("User-Agent");
		            boolean isMSIE = (agent != null && agent.indexOf("MSIE") != -1);
		            if( isMSIE ){
		            	fileName = URLEncoder.encode(fileName,"UTF8");
		            }else{
		            	fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		            }
		            //response.addHeader("Content-Length", "" + file.length());
		            response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".csv");//这里设置一下让浏览器弹出下载提示框，而不是直接在浏览器中打开
		           // response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".txt");
		              ExportCsvUtil.createCSVFile(exportData, map, response.getOutputStream());
		          //  ExportCsvUtil.createTxtFile("6901285991219\t1\r\n6928防护等级459\t1",response.getOutputStream());

		        } catch (IOException e) {
		            e.printStackTrace();

		        }
		}
	
	}
	
}
