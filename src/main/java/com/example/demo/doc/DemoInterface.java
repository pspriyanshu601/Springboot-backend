package com.example.demo.doc;

import com.example.demo.dto.DemoResponse;
import com.example.demo.model.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("Demo")
public interface DemoInterface {
    @GetMapping("/firstEndpoint")
    ResponseEntity<List<DemoResponse>> fun();
}
