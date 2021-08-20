package com.myredis.test.controller;

import com.myredis.test.entity.UserEntity;
import com.myredis.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LogonController {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.password}")
    private String password;

    @Autowired
    private UserService userService;

    @RequestMapping("logon")
    public String logonCheck(UserEntity entity){

        if(entity!=null){
            String username = entity.getUsername();
            Map<String,Object> map= new HashMap<>();
            map.put("username",username);
            Jedis jedis = new Jedis(host,port);
            jedis.auth(password);
            String password = jedis.get(username);
            if(password==null){
                List<UserEntity> list = userService.getListByParameter(map);
                if(list.size()>0) {
                    String psd = list.get(0).getPassword();
                    jedis.set(username, psd);
                    if (entity.getPassword().equals(psd)) {
                        return "index";
                    }
                }
            }else if(!"".equals(password) && entity.getPassword().equals(password)){
                return "index";
            }

        }
        return "logon";
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public UserEntity getUser(){
        Map<String,Object> map= new HashMap<>();
        map.put("username","test");
        UserEntity list = userService.selectByPrimaryKey(1);
        return list;
    }
}
