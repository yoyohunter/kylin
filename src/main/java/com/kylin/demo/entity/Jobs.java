package com.kylin.demo.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * @Classname Jobs
 * @Description TODO
 * @Date 2019-08-21 14:24
 * @Created by zhangbinbin
 */
public class Jobs {
    private String submitter;

    @JSONField(name = "job_status")
    private String jobStatus;

    @JSONField(name = "related_cube")
    private String relateCube;

    @JSONField(name = "steps")
    private List<Job> steps;

    public String getSubmitter() {
        return submitter;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getRelateCube() {
        return relateCube;
    }

    public void setRelateCube(String relateCube) {
        this.relateCube = relateCube;
    }

    public List<Job> getSteps() {
        return steps;
    }

    public void setSteps(List<Job> steps) {
        this.steps = steps;
    }
}
