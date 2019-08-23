package com.kylin.demo.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * @Classname Model
 * @Description TODO
 * @Date 2019-08-21 21:29
 * @Created by zhangbinbin
 */
public class Model {

    private String name;

    @JSONField(name = "fact_table")
    private String factTable;

    private List<Table> lookups;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Table> getLookups() {
        return lookups;
    }

    public void setLookups(List<Table> lookups) {
        this.lookups = lookups;
    }

    public String getFactTable() {
        return factTable;
    }

    public void setFactTable(String factTable) {
        this.factTable = factTable;
    }
}
