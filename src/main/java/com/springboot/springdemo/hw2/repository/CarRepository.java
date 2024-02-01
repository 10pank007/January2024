package com.springboot.springdemo.hw2.repository;

import com.springboot.springdemo.hw2.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findAllByPower(Double power);

    List<Car> findAllByProducer(String producer);
}
