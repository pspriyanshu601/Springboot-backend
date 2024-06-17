package com.example.demo.service;

import com.example.demo.dto.DemoResponse;
import com.example.demo.model.Test;
import com.example.demo.repository.TestRepository;
import com.example.demo.utils.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class TestService {
    @Autowired
    TestRepository testRepository;

    @Autowired
    private RedisClient redisClient;

    public List<DemoResponse> getAllData(){
        List<DemoResponse> redisData= (List<DemoResponse>) redisClient.get("testData1");
        System.out.println(redisData);
        if(redisData!=null){
            return redisData;
        }
        else{
            List<DemoResponse> responses=new ArrayList<>();
            List<Test> response=testRepository.findAll();
            for(Test test:response){
                DemoResponse res=new DemoResponse();
                res.setId(test.getId());
                res.setName(test.getName());
                res.setAddress(test.getAddress());
                res.setClassNum(test.getClassNum());
                responses.add(res);
            }
            redisClient.setData("testData1",responses,3L*60L*60L,TimeUnit.MINUTES);
            return responses;
        }


    }
}
