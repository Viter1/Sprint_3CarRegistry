package com.vitech.CarRegistry.services;

import com.vitech.CarRegistry.controller.dtos.CarRequest;
import com.vitech.CarRegistry.domain.Car;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface CarService {

    Car getCarById(Integer id) ;

    void deleteById(Integer id) ;

    Car updateById(Integer id , Car carRequest) ;

    Car saveCar(Car carRequest);

    List<Car> getAllCars();

}
