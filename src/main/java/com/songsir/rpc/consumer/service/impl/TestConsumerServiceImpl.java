package com.songsir.rpc.consumer.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.songsir.rpc.consumer.service.TestConsumerService;
import com.songsir.rpc.provider.service.TestProviderService;
import org.springframework.stereotype.Service;

/**
 * @PackageName com.songsir.rpc.consumer.service.impl
 * @ProjectName songsir-rpc-consumer-web
 * @Author: SongYapeng
 * @Date: Create in 19:46 2019/12/18
 * @Description:
 * @Copyright Copyright (c) 2019, songsir01@163.com All Rights Reserved.
 */
@Service
public class TestConsumerServiceImpl implements TestConsumerService {

    @Reference(version = "1.0.0", check = false)
    private TestProviderService testProviderService;
    @Override
    public String getHelloWorld(String word) {
        return testProviderService.getHelloWorld(word);
    }
}
