package com.springboot.springdemo.hw1.dao;


import com.springboot.springdemo.hw1.entity.Car;
import jakarta.persistence.EntityManager;


import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class CarDao {
    private final EntityManager entityManager;


    public List<Car> getAllCars() {
        TypedQuery<Car> selectPFromCarP = entityManager.createQuery("select p from Car p", Car.class);
        return selectPFromCarP.getResultList();
    }

    public Car getCarById(int id) {
        TypedQuery<Car> query = entityManager.createQuery("select p from Car p where id=:id", Car.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
    @Transactional
    public Car saveCar(Car car) {
        entityManager.persist(car);
        return car;
    }

    @Transactional
    public Car deleteById(int id) {
        Car car = entityManager.find(Car.class, id);
        entityManager.remove(car);
        return car;
    }

    public List<Car> getByPowerValue(int value) {
        TypedQuery<Car> query = entityManager.createQuery("select c from Car c where c.power=:value", Car.class);
        query.setParameter("value",value);
        return query.getResultList();
    }

    public List<Car> getByProducerValue(String value) {
        TypedQuery<Car> query = entityManager.createQuery("select c from Car c where c.producer=:value", Car.class);
        query.setParameter("value",value);
        return query.getResultList();
    }
}
