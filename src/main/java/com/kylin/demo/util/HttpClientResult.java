package com.kylin.demo.util;

import java.io.Serializable;

/**
 * @Classname HttpClientResult
 * @Description TODO
 * @Date 2019-08-21 00:02
 * @Created by zhangbinbin
 */
public class HttpClientResult implements Serializable {
    public HttpClientResult(int code) {
        this.code = code;
    }

    public HttpClientResult(int code, String content) {
        this.code = code;
        this.content = content;
    }

    /**
     * 响应状态码
     */
    private int code;

    /**
     * 响应数据
     */
    private String content;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}