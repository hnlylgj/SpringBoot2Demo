package com.hnly.springboot.WebFluxDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController 
{
    
    @RequestMapping("/hello")//此处控制浏览器里访问路径 具体为：/hello
    public @ResponseBody String test()      
    {
    	 //String clientName=request.getParameter("clientName");
    	 //if(clientName==null)
    	 // clientName="我的朋友";
     
    	 return "hello, world! This com from spring!";
    }
}

