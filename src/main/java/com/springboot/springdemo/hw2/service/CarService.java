package com.springboot.springdemo.hw2.service;

import com.springboot.springdemo.hw2.dto.CarDTO;
import com.springboot.springdemo.hw2.entity.Car;
import com.springboot.springdemo.hw2.mapper.CarMapper;
import com.springboot.springdemo.hw2.repository.CarRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Component
public class CarService {
    private CarRepository carRepository;
    private CarMapper carMapper;

    public List<CarDTO> getAllCar() {
        List<Car> all = carRepository.findAll();
        return all.stream().map(CarMapper::toCarDTO).toList();
    }

    public Optional<CarDTO> getCarById(int id) {
        Optional<Car> car = carRepository.findById(id);
        return car.map(CarMapper::toCarDTO);
    }

    public ResponseEntity<CarDTO> postCar(Car car) {
        Car createCar = carRepository.save(car);
        URI uriOfCreatedCar = UriComponentsBuilder.fromPath("/cars/{id}").build(createCar.getId());
        return ResponseEntity.created(uriOfCreatedCar).build();
    }
    public void deleteCarById(int id) {
        carRepository.deleteById(id);
    }
    public List<CarDTO> getAllProductsByPower(Double value) {
        List<Car> allByPower = carRepository.findAllByPower(value);
        return allByPower.stream().map(CarMapper::toCarDTO).toList();
    }

    public List<CarDTO> getAllProductsByProducer(String value) {
        List<Car> allByPower = carRepository.findAllByProducer(value);
        return allByPower.stream().map(CarMapper::toCarDTO).toList();
    }

}

