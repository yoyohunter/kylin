package com.kylin.demo.service;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.kylin.demo.entity.Cube;
import com.kylin.demo.entity.Jobs;
import com.kylin.demo.entity.Model;
import com.kylin.demo.util.FastJsonUtils;
import com.kylin.demo.util.HttpClientResult;
import com.kylin.demo.util.HttpClientUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname ScheduleService
 * @Description TODO
 * @Date 2019-08-20 23:11
 * @Created by zhangbinbin
 */
@Service
public class ScheduleService {


    /**
     * 每天7点
     *
     * @throws Exception test
     * @Scheduled(cron = "1/5 * * * * *")
     */
    @Scheduled(cron = "0 0 7 * * ?")
    public void task1() throws Exception {


        //获取job列表
        List<Jobs> jobs = getJobs();

        //设定相关报警规则
        //TODO 哪些job需要报警， TODO 报警给哪些人

        //调用报警接口

    }

    public List<Jobs> getJobs() throws Exception {

//        String url = "http://192.168.1.33:7070/kylin/api/jobs?projectName=gjyb&offset=0&limit=10&timeFilter=2&status=8";
        String url = "http://10.255.1.117:7070/kylin/api/jobs?projectName=gjyb&offset=0&limit=10&timeFilter=2&status=8";

        HttpClientResult result = HttpClientUtils.doGet(url, getHeader(), null);
        return FastJsonUtils.toList(result.getContent(), Jobs.class);
    }

    public String getMessage(String tableName) throws Exception {
//        String url = "http://192.168.1.33:7070/kylin/api/cubes";
        String url = "http://10.255.1.117:7070/kylin/api/cubes";

        HashMap<String, String> params = Maps.newHashMap();
        params.put("offset", "0");
        params.put("limit", "100");
        HttpClientResult result = HttpClientUtils.doGet(url, getHeader(), params);

        List<Cube> cubes = FastJsonUtils.toList(result.getContent(), Cube.class);


        List<String> mobels = Lists.newArrayList();


        cubes.stream().forEach(it->{
            if(tableName.equals(it.getModelBo().getFactTable())){
                mobels.add(it.getModel());
            }
        });

        String s = JSON.toJSONString(mobels);


        File file =new File("/data/");


        FileOutputStream fileOutputStream = new FileOutputStream(file);

        fileOutputStream.write(s.getBytes());

        ResourceUtils.getURL("");

        return JSON.toJSONString(mobels);


//
//
//        cubes.stream().forEach(item -> {
//            item.setModelBo(getModle(item.getModel()));
//        });
//
//        String s = FastJsonUtils.toJSONString(cubes);
//
//        return s;
    }

    public Model getModle(String modelName) {

//        String url = "http://192.168.1.33:7070/kylin/api/model/";
        String url = "http://10.255.1.117:7070/kylin/api/model/";
        url = url + modelName;
        HttpClientResult result = null;
        try {
            result = HttpClientUtils.doGet(url, getHeader(), null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Model model = FastJsonUtils.toBean(result.getContent(), Model.class);
        return model;
    }


    private Map getHeader() {
        HashMap<String, String> header = Maps.newHashMap();
        header.put("Content-Type", "application/json");
        header.put("Authorization", "Basic QURNSU46d2VpeWlhZG1pbg==");

        //Basic QURNSU46d2VpeWlhZG1pbg==
        return header;
    }


}
