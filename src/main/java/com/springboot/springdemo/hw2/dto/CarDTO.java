package com.springboot.springdemo.hw2.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.springboot.springdemo.hw2.util.View;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarDTO {
    @JsonView(View.Level1.class)
    private int id;
    @JsonView(View.Level3.class)
    @NotBlank(message = "model can't be blank")
    private String model;
    @JsonView(View.Level3.class)
    @NotBlank(message = "producer can't be blank")
    private String producer;
    @JsonView(View.Level2.class)
    @Min(value = 0, message = "power can't be less than 0")
    @Max(value = 100, message = "power can't be more than 100")
    private double power;
}
