package com.springboot.springdemo.hw2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "model can't be blank")
    private String model;
    @NotBlank(message = "producer can't be blank")
    private String producer;
    @Min(value = 0, message = "power can't be less than 0")
    @Max(value = 100, message = "power can't be more than 100")
    private Double power;
}
