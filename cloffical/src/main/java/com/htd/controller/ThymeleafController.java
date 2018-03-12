package com.htd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.htd.dao.UserMapper;
import com.htd.domain.User;


@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {
	@Autowired
	UserMapper userMapper;
	
    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String greeting(Model model) {
		String name ="李明";
//		User user = userMapper.findUserByName(name).get(0);
		List<User> user = userMapper.findUserByName();
		model.addAttribute("xname", user);
        return "ints";
    }

    @ResponseBody
    @RequestMapping(value = "/ajax", method = RequestMethod.GET)
    public String ajax(@RequestParam("username") String username){
        return username;
    }

}
