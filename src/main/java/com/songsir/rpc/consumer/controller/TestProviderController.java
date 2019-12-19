package com.songsir.rpc.consumer.controller;

import com.songsir.rpc.consumer.service.TestConsumerService;
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

    @RequestMapping("testConsumer")
    public String testConsumer() {
        return testConsumerService.getHelloWorld("");
    }

}
