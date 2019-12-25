package com.songsir.rpc.consumer.controller;

import com.songsir.rpc.consumer.service.TestConsumerService;
import com.songsir.rpc.utils.MyRedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private TestConsumerService testConsumerService;
    @Autowired
    private MyRedisTemplate redisTemplate;

    @RequestMapping("testConsumer")
    public String testConsumer() {
        return testConsumerService.getHelloWorld("");
    }

    @RequestMapping("testRedis")
    public String testRedis() {
        boolean set = redisTemplate.set("songsir", "songsirone", 100);
        System.out.println(set);
        Object songsir = redisTemplate.get("songsir");
        System.out.println(songsir);
        return "success";
    }

}
