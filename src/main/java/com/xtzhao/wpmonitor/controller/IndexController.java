package com.xtzhao.wpmonitor.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xtzhao.wpmonitor.bean.FreeMakerConfig;

@RestController
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	FreeMakerConfig fc;
	
	@RequestMapping
	public String start(){
		return "Welcome to my system!"; 
	}
	
	@RequestMapping("/index")
	public String index(){
		Map<String,String> result = new HashMap<>();
	    result.put("name","test");
	    result.put("age","20");
	    return fc.resolveMap(result,"index.ftl");
	}
	
}
