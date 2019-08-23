package com.kylin.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * @Classname Cube
 * @Description TODO
 * @Date 2019-08-21 21:29
 * @Created by zhangbinbin
 */
public class Cube {

    private String name;

    private String model;

    private String status;

    private Model modelBo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Model getModelBo() {
        return modelBo;
    }

    public void setModelBo(Model modelBo) {
        this.modelBo = modelBo;
    }
}
