package com.example.demo.controller;

import com.example.demo.doc.DemoInterface;
import com.example.demo.dto.DemoResponse;
import com.example.demo.model.Test;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController implements DemoInterface {

    @Autowired
    TestService testService;

    @Override
    public ResponseEntity<List<DemoResponse>> fun() {

        return ResponseEntity.ok(testService.getAllData());

    }

}
