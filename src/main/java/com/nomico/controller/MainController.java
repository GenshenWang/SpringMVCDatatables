package com.nomico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by wanggenshen_sx on 2017/1/5.
 */
@Controller
public class MainController {

	@RequestMapping(value="/index",method = RequestMethod.GET)
	public String index(){
		return "index";
	}
}
