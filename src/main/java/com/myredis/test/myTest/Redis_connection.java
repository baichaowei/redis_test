package com.myredis.test.myTest;

import com.myredis.test.common.config.RedisConfig;
import com.myredis.test.common.service.RedisCacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import java.util.Date;

@Controller
public class Redis_connection {
    public static Logger logger = LoggerFactory.getLogger(Redis_connection.class);
    @Autowired
    private RedisCacheService redisCacheService;
    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.password}")
    private String password;
    @RequestMapping("/redisTest")
    @ResponseBody
    public String redisTest(){
        Jedis jedis = new Jedis(host,port);
        jedis.auth(password);
        String javaKey = jedis.get("javaKey");
        System.out.println(javaKey);
        logger.info("/************/javaKey："+javaKey);
        return javaKey;
    }


    public static void main(String[] args) {
        //初始化jedis对象
        //Jedis jedis = new Jedis("192.168.52.129",6379);
        //测试redis主机连通性
        //jedis.auth("123456");
        //String ping = jedis.ping();
        //System.out.println(ping);

        //向redis插入数据
        //jedis.set("javaKey","hello world");
        //String javaKey = jedis.get("javaKey");
        //System.out.println(javaKey);
       /* String test = "abcd";
        String str = test.substring(0, 1);
        String str2 = test.substring(1, 2);
        System.out.println(str);
        System.out.println(str2);
        String a="a";
        String b="b";
        System.out.println(test.substring(0, 1).equals("a"));
        System.out.println(test.substring(1, 2).equals("b"));*/
        Date date = new Date(0);
        System.out.println(date);

        String abc = "abc";
        System.out.println(abc.contains("b"));
        System.out.println(abc.contains("d"));
        System.out.println("*******************");
        int total = 49;
        int dataSize = 500;
        int s = total/dataSize;
        System.out.println(s);
        int y = total%dataSize;
        System.out.println(y);

        float ft = 123.2f;
        System.out.println(ft);
        double de = 212345678.3;
        System.out.println(de);

    }
}
