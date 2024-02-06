package com.springboot.springdemo.hw2.service;

import com.springboot.springdemo.hw2.dto.CarDTO;
import com.springboot.springdemo.hw2.entity.Car;
import com.springboot.springdemo.hw2.mapper.CarMapper;
import com.springboot.springdemo.hw2.repository.CarRepository;
import lombok.AllArgsConstructor;
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


    public CarService(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    public List<CarDTO> getAllCar() {
        List<Car> all = carRepository.findAll();
        return all.stream().map(carMapper::toCarDTO).toList();
    }

    public Optional<CarDTO> getCarById(int id) {
        Optional<Car> car = carRepository.findById(id);
        return car.map(carMapper::toCarDTO);
    }

    public ResponseEntity<CarDTO> postCar(CarDTO carDTO) {
        Car car = carMapper.fromCarDTO(carDTO);
        Car createCar = carRepository.save(car);
        URI uriOfCreatedCar = UriComponentsBuilder.fromPath("/cars/{id}").build(createCar.getId());
        return ResponseEntity.created(uriOfCreatedCar).build();
    }
    public void deleteCarById(int id) {
        carRepository.deleteById(id);
    }
    public List<CarDTO> getAllProductsByPower(Double value) {
        List<Car> allByPower = carRepository.findAllByPower(value);
        return allByPower.stream().map(carMapper::toCarDTO).toList();
    }

    public List<CarDTO> getAllProductsByProducer(String value) {
        List<Car> allByPower = carRepository.findAllByProducer(value);
        return allByPower.stream().map(carMapper::toCarDTO).toList();
    }

}

