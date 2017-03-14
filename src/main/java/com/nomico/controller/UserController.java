package com.nomico.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.nomico.model.Department;
import com.nomico.model.User;
import com.nomico.service.DepartmentService;
import com.nomico.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Controller
public class UserController implements Serializable {

	private static final long serialVersionUID = 851051608237887490L;

	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public String login(User user, HttpServletRequest request){
		user.setPassword(user.getPassword());
		User resultUser=null;
	
		resultUser=	userService.selectByPramater(user);
		if(null != resultUser){
			HttpSession session = request.getSession();
			session.setAttribute("currentUser", resultUser);
			return "main";
		}else{
			request.setAttribute("user", user);
			request.setAttribute("errorMsg", "用户名或密码错误！");
			return "login";
		}
	}
	
	@RequestMapping("user/list1")
	public String login1(){
		return "jps";
	}
	
	@RequestMapping(value="user/list")
	public String list(Integer iDisplayStart, Integer iDisplayLength,HttpServletRequest request){
	JSONObject jsonObject=new JSONObject();
	
	if(iDisplayStart==null){
		iDisplayStart=0;
	}
        //pageNum  当前传过来的页码               15代表每页显示多少条
		PageHelper.startPage(iDisplayStart,3);
		List<User> list=	userService.selectAll(new User());
		PageInfo pageinfo=new PageInfo(list);
	       // Map<String, Object> map = new HashMap<String, Object>();
		    jsonObject.put("iTotalRecords", pageinfo.getTotal());
	        jsonObject.put("iTotalDisplayRecords", pageinfo.getTotal());
	        jsonObject.put("aaData", list);
	  
	        return jsonObject.toJSONString();
	}
	
	@RequestMapping("user/addjsp")
	public ModelAndView addjsp(){
		ModelAndView model=new ModelAndView();
		List<Department> list=null;
				//departmentService.selectAll(new Department());
		model.addObject("mainPage", "user/save.jsp");
		model.addObject("modeName", "添加用户");
		model.addObject("list",list);
		model.setViewName("main");
		return model;
	}
	


	@RequestMapping("/user/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/login.jsp";
	}	

}
