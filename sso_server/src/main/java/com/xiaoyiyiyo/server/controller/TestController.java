package com.xiaoyiyiyo.server.controller;

import com.xiaoyiyiyo.server.common.pojo.UserDo;
import com.xiaoyiyiyo.server.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhongkf on 2019/01/22
 */
@RestController
public class TestController {

    @Autowired
    private IUserService userService;


    @Autowired
    private RedisTemplate redisTemplate;


    @RequestMapping("/test1")
    public String getUsers() {

        UserDo user = userService.getUser("root","111");
        //根据token, 缓存用户
        redisTemplate.opsForValue().set("user:", user);



        return redisTemplate.opsForValue().get("user").toString();

    }

}