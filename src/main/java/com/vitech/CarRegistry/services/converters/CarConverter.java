package com.vitech.CarRegistry.services.converters;

import com.vitech.CarRegistry.domain.Car;
import com.vitech.CarRegistry.entity.CarEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarConverter {

    @Autowired
    private BrandConverter brandConverter;

    public Car toCar(CarEntity entity){
        Car car = new Car();
        car.setId(entity.getId());
        car.setColour(entity.getColour());
        car.setDescription(entity.getDescription());
        car.setFueltype(entity.getFueltype());
        car.setMillage(entity.getMillage());
        car.setModel(entity.getModel());
        car.setNumDoors(entity.getNumDoors());
        car.setPrice(entity.getPrice());
        car.setYear(entity.getYear());


        car.setBrand(brandConverter.toBrand(entity.getBrand()));

        return car;
    }

    public CarEntity toEntity(Car car){
        CarEntity car_toEnt   = new CarEntity();
        car_toEnt.setId(car.getId());
        car_toEnt.setColour(car.getColour());
        car_toEnt.setDescription(car.getDescription());
        car_toEnt.setFueltype(car.getFueltype());
        car_toEnt.setMillage(car.getMillage());
        car_toEnt.setModel(car.getModel());
        car_toEnt.setNumDoors(car.getNumDoors());
        car_toEnt.setPrice(car.getPrice());
        car_toEnt.setYear(car.getYear());
        car_toEnt.setBrand(brandConverter.toEntity(car.getBrand()));

        return car_toEnt;
    }
}
