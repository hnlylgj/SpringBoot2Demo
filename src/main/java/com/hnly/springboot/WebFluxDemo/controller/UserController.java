package com.hnly.springboot.WebFluxDemo.controller;

import java.util.Date;  
import java.util.HashMap;  
import java.util.Map;  

import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RestController;

import com.hnly.springboot.WebFluxDemo.bean.User;  



@RestController  
@RequestMapping(value = "/user")  
public class UserController 
{  

    @RequestMapping  
    public String index() 
    {  
        return "Hello BeiJing";  
    }  

    @RequestMapping(value = "/getMap")  
    public Map<String, Object> getThisMap(String msg) 
    {  
        Map<String, Object> map = new HashMap<String, Object>();  
        map.put("Name", "李庚君");  
        map.put("Sex", "男");  
        map.put("Message", "HashMap 和 HashSet 是 Java Collection Framework 的两个重要成员");  
        return map;  
    }  

    @RequestMapping(value = "/getUser/{name}/{sex}")  
    public User getUser(@PathVariable String name, @PathVariable char sex)
    {  
        User user = new User();  
        user.setId(12);  
        user.setName(name);  
        user.setDate(new Date());  
        user.setSex(sex);  
        return user;  
    }  

}  

