package com.songsir.rpc.consumer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @PackageName com.songsir.rpc.consumer.controller
 * @ProjectName songsir-rpc-consumer-web
 * @Author: SongYapeng
 * @Date: Create in 15:24 2019/12/31
 * @Description:
 * @Copyright Copyright (c) 2019, songsir01@163.com All Rights Reserved.
 */
@Controller
public class SongsirController {

    @RequestMapping("/index")
    public String index() {

        return "index";
    }
}
