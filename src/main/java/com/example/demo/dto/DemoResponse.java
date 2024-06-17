package com.example.demo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Data
@Getter
@Setter
@ToString
public class DemoResponse implements Serializable {
    private Long id;
    private String name;
    private String address;
    private Long classNum;
}
