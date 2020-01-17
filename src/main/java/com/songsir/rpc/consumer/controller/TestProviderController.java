package com.songsir.rpc.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.songsir.rpc.bean.User;
import com.songsir.rpc.provider.service.TestProviderService;
import com.songsir.rpc.utils.HttpUtil;
import com.songsir.rpc.utils.MyRedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @PackageName com.songsir.rpc.consumer.controller
 * @ProjectName songsir-rpc-consumer-web
 * @Author: SongYapeng
 * @Date: Create in 19:45 2019/12/18
 * @Description:
 * @Copyright Copyright (c) 2019, songsir01@163.com All Rights Reserved.
 */
@RestController
public class TestProviderController {

    @Autowired
    private MyRedisTemplate redisTemplate;

    @Reference(version = "1.0.0", check = false)
    private TestProviderService testProviderService;

    @RequestMapping("testConsumer")
    public String testConsumer() {
        User user = new User();
        user.setUid(1);
        List<User> userByUid = testProviderService.getUserByUid(user);
        System.out.println(userByUid);
        return testProviderService.getHelloWorld("");
    }

    @RequestMapping("testRedis")
    public String testRedis() {
        boolean set = redisTemplate.set("songsir", "songsirone", 100);
        System.out.println(set);
        Object songsir = redisTemplate.get("songsir");
        System.out.println(songsir);
        return "success";
    }

    @RequestMapping("/testHttpLinkOrRpc")
    public String testHttpLinkOrRpc() {
        long l = System.currentTimeMillis();
        String str = testProviderService.testUseHttpOrRpc();
        System.out.println(str);
        System.err.println("use rpc time = " + (System.currentTimeMillis() - l));
        long l1 = System.currentTimeMillis();
        String str2 = HttpUtil.sendGet("http://localhost:8090/useHttpLinkTest", "");
        System.out.println(str2);
        System.err.println("use http time = " + (System.currentTimeMillis() - l1));
        return "hello world!";
    }

}
