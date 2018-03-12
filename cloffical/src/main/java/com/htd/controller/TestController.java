package com.htd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.htd.dao.UserMapper;
import com.htd.domain.User;
import com.htd.service.IRedisService;


@Controller
@RequestMapping(path="/user")
public class TestController {

//    @Autowired
//    private UserService userService;
	
	@Autowired

	UserMapper userMapper;
	
    @Autowired
    private IRedisService redisService;

    //从redis获取某个用户
    @RequestMapping(value = "/getuserfromredis", method = RequestMethod.GET)
    public @ResponseBody User getRedis(@RequestParam String key) {
        return (User)redisService.get(key);
    }

    //获取所有用户
    @RequestMapping(value = "/getusers", method = RequestMethod.GET)
    public @ResponseBody Page<User> list(Model model, Pageable pageable){
        return (Page<User>) userMapper.findUserByName(); 
    }
//
//    //添加用户
//    @GetMapping(value="/adduser")
//    public @ResponseBody String addUser(@RequestParam String dictum,
//            @RequestParam String password, @RequestParam String username) {
//        User user = new User();
//        user.setDictum(dictum);
//        user.setPassword(password);
//        user.setUsername(username);
//        System.out.println(user);
//        userService.saveUser(user);
//        redisService.set(user.getId()+"", user);
//        return "Saved";
//    }
}