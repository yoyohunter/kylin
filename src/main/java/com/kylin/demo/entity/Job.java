package com.kylin.demo.entity;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @Classname Job
 * @Description TODO
 * @Date 2019-08-21 14:20
 * @Created by zhangbinbin
 */

public class Job {

    @JSONField(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
