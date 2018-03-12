package com.htd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.htd.dao.UserMapper;
import com.htd.domain.User;

@RestController

@RequestMapping("/user")

public class UserController {

@Autowired

UserMapper userMapper;

@RequestMapping(value="/user")
	public String getUserInfoByName() {
	
		List<User> user = userMapper.findUserByName();
		
		System.out.println("user========"+user.get(0).getName());
		return "ddd";
	}

@RequestMapping(value = "/index")
public ModelAndView toIndex(){
    ModelAndView mv = new ModelAndView("index");
    return mv;
}
}


