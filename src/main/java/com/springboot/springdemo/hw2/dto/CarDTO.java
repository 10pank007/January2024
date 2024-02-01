package com.springboot.springdemo.hw2.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.springboot.springdemo.hw2.util.View;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarDTO {
    @JsonView(View.Level1.class)
    private int id;
    @JsonView(View.Level3.class)
    private String model;
    @JsonView(View.Level3.class)
    private String producer;
    @JsonView(View.Level2.class)
    private double power;
}
