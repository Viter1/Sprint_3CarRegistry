package com.vitech.CarRegistry.services.impl;


import com.vitech.CarRegistry.domain.Car;
import com.vitech.CarRegistry.entity.CarEntity;
import com.vitech.CarRegistry.repository.CarRepository;
import com.vitech.CarRegistry.services.CarService;

import com.vitech.CarRegistry.services.converters.CarConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class CarServiceImpl implements CarService {



    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarConverter carConverter;

    //List<CarResponse> carResponseList = poblateCarList();

    @Override
    public Car getCarById(Integer id) {
        log.info("Getting car to Database with id {}   ", id);
        Optional<CarEntity> carOptional = carRepository.findById(id);
        if (carOptional.isPresent()){
            return carConverter.toCar(carOptional.get());
        }
        return null;

    }

    @Override
    public void deleteById(Integer id) {
        log.info("Deleting car whith id {}" , id);
        carRepository.deleteById(id);

    }


    @Override
    public Car saveCar(Car carRequest) {
        log.info("Adding car to Database ....  ");
        CarEntity entity = carRepository.save(carConverter.toEntity(carRequest));
        return carConverter.toCar(carRepository.save(entity));
    }

    @Override
    public Car updateById(Integer id, Car carRequest)  {
        log.info("Updating car to Database with id {}   ", id);
        Optional<CarEntity> carOptional =  carRepository.findById(id);


        if(carOptional.isPresent()){
            CarEntity entity = carConverter.toEntity(carRequest);
            entity.setId(id);

            return carConverter.toCar(carRepository.save(entity));
        }
        return null;
    }


    @Override
    //@Async
    public List<Car> getAllCars(){
        List<CarEntity> carsList = carRepository.findAll();
        List<Car> cars = new ArrayList<>();
        carsList.forEach(car -> {
            cars.add(carConverter.toCar(car));
        } );
        return  cars;
    }




//    private List<CarResponse> poblateCarList(){
//        List<CarResponse> carList = new ArrayList<>();
//
//        CarResponse car = new CarResponse();
//        car.setId(1);
//        car.setBrand("Renoult");
//        car.setModel("Clio");
//        car.setMillage(10000);
//        car.setPrice(2000.99);
//
//        carList.add(car);
//
//        CarResponse car2 = new CarResponse();
//        car2.setId(2);
//        car2.setBrand("Renoult");
//        car2.setModel("megane");
//        car2.setMillage(10000);
//        car2.setPrice(3000.99);
//
//        carList.add(car2);
//
//
//        return carList;
//    }
//
//    private CarResponse mapper(CarRequest request){
//        CarResponse car = new CarResponse();
//        car.setId(request.getId());
//        car.setBrand(request.getBrand());
//        car.setModel(request.getModel());
//        car.setMillage(request.getMillage());
//        car.setPrice(request.getPrice());
//
//
//        return car;
//    }

}
