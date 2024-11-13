package com.vitech.CarRegistry.controller.mapper;

import com.vitech.CarRegistry.controller.dtos.CarRequest;
import com.vitech.CarRegistry.controller.dtos.CarResponse;
import com.vitech.CarRegistry.domain.Car;
import com.vitech.CarRegistry.entity.CarEntity;
import com.vitech.CarRegistry.services.converters.BrandConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CarMapper {

    @Autowired
    private BrandMapper brandMapper;

    public CarResponse toResponse (Car entity){
        CarResponse carResponse = new CarResponse();
        carResponse.setId(entity.getId());
        carResponse.setColour(entity.getColour());
        carResponse.setDescription(entity.getDescription());
        carResponse.setFueltype(entity.getFueltype());
        carResponse.setMillage(entity.getMillage());
        carResponse.setModel(entity.getModel());
        carResponse.setNumDoors(entity.getNumDoors());
        carResponse.setPrice(entity.getPrice());
        carResponse.setYear(entity.getYear());
        carResponse.setBrand(brandMapper.toResponse(entity.getBrand()));

        return carResponse;
    }

    public Car toModel (CarRequest model){
        Car car   = new Car();
        car.setId(model.getId());
        car.setColour(model.getColour());
        car.setDescription(model.getDescription());
        car.setFueltype(model.getFueltype());
        car.setMillage(model.getMillage());
        car.setModel(model.getModel());
        car.setNumDoors(model.getNumDoors());
        car.setPrice(model.getPrice());
        car.setYear(model.getYear());
        car.setBrand(brandMapper.toModel(model.getBrand()));

        return car;
    }
}
