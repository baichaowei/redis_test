package com.myredis.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @RequestMapping("/home")
    public String index(){
        return "index";
    }
    @RequestMapping("/")
    public String logon(){
        return "logon";
    }
}
