package com.springboot.springdemo.hw1.controller;

import com.springboot.springdemo.hw1.dao.CarDao;
import com.springboot.springdemo.hw1.entity.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarDao carDao;

    @GetMapping()
    public ResponseEntity<List<Car>> getProducts() {
        return ResponseEntity.ok(carDao.getAllCars());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable("id") int id) {
        return ResponseEntity.ok(carDao.getCarById(id));
    }

    @PostMapping()
    public ResponseEntity<Car> createCar(@RequestBody  Car car) {
        Car resultCar = carDao.saveCar(car);
        return ResponseEntity.ok().body(resultCar);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Car> deleteCarById(@PathVariable("id") int id) {
        return ResponseEntity.ok(carDao.deleteById(id));
    }
    @GetMapping("/power/{value}")
    public ResponseEntity<List<Car>> getByPowerValue(@PathVariable("value") int value) {
        return ResponseEntity.ok(carDao.getByPowerValue(value));
    }
    @GetMapping("/producer/{value}")
    public ResponseEntity<List<Car>> getByProducerValue(@PathVariable("value") String value) {
        return ResponseEntity.ok(carDao.getByProducerValue(value));
    }
}
