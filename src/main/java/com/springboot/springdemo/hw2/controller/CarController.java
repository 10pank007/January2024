package com.springboot.springdemo.hw2.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.springboot.springdemo.hw2.dto.CarDTO;
import com.springboot.springdemo.hw2.entity.Car;
import com.springboot.springdemo.hw2.mapper.CarMapper;
import com.springboot.springdemo.hw2.repository.CarRepository;
import com.springboot.springdemo.hw2.service.CarService;
import com.springboot.springdemo.hw2.util.View;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarRepository carRepository;
    private final CarMapper carMapper;
    private final CarService carService;

    @JsonView(View.Level3.class)
    @GetMapping
    public ResponseEntity<List<CarDTO>> getAllCar() {
        return  ResponseEntity.ok(carService.getAllCar());
    }

    @JsonView(View.Level1.class)
    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> getCarById(@PathVariable("id") int id) {
        return ResponseEntity.of(carService.getCarById(id));
    }

    @PostMapping
    public ResponseEntity<CarDTO> createCar(@RequestBody @Valid Car car ) {
        return carService.postCar(car);
    }

    @DeleteMapping("/{id}")
    public void deleteCarById(@PathVariable("id") int id) {
       carService.deleteCarById(id);
    }

    @JsonView(View.Level2.class)
    @GetMapping("/power/{value}")
    public ResponseEntity<List<CarDTO>> getCarsByPowerValue(@PathVariable Double value) {
        return ResponseEntity.ok(carService.getAllProductsByPower(value));
    }

    @JsonView(View.Level2.class)
    @GetMapping("/producer/{value}")
    public ResponseEntity<List<CarDTO>> getCarByProducerValue(@PathVariable String value) {
        return ResponseEntity.ok(carService.getAllProductsByProducer(value));    }


}
