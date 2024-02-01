package com.springboot.springdemo.hw2.mapper;

import com.springboot.springdemo.hw2.dto.CarDTO;
import com.springboot.springdemo.hw2.entity.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {
    public static CarDTO toCarDTO(Car car) {
        return CarDTO.builder()
                .id(car.getId())
                .power(car.getPower())
                .producer(car.getProducer())
                .model(car.getModel())
                .build();

    }
    public Car fromCarDTO(CarDTO carDTO) {
        Car car = new Car();
        car.setPower(carDTO.getPower());
        car.setModel(carDTO.getModel());
        car.setProducer(carDTO.getProducer());
        return car;
    }
}
