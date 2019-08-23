package com.kylin.demo.controller;

import com.kylin.demo.service.ScheduleService;
import com.kylin.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname TestController
 * @Description TODO
 * @Date 2019-08-20 20:47
 * @Created by zhangbinbin
 */
@RestController
public class TestController {
    @Autowired
    private TestService testService;

    @Autowired
    private ScheduleService scheduleService;
    @GetMapping("/")
    public String getName(){
        return "hello";
    }
    @GetMapping("/get")
    public String get(){
        return testService.get();
    }

    @GetMapping("/message")
    public String message() throws Exception {
        return scheduleService.getMessage();
    }
}
