package com.vitech.CarRegistry.services.impl;


import com.vitech.CarRegistry.domain.Car;
import com.vitech.CarRegistry.entity.CarEntity;
import com.vitech.CarRegistry.repository.BrandRepository;
import com.vitech.CarRegistry.repository.CarRepository;
import com.vitech.CarRegistry.services.CarService;

import com.vitech.CarRegistry.services.converters.CarConverter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    private BrandRepository brandRepository;

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

    @Override
    public String carsCsv() {
        List<CarEntity> carList = carRepository.findAll();
        StringBuilder csvContent = new StringBuilder();

        for (CarEntity car : carList){
            csvContent.append(car.getBrand()).append(",")
                    .append(car.getModel()).append(",")
                    .append(car.getColour()).append(",")
                    .append(car.getDescription()).append(",")
                    .append(car.getYear()).append(",")
                    .append(car.getPrice()).append(",")
                    .append("\n");
        }



        return csvContent.toString();
    }

    @Override
    public void uploadCars(MultipartFile file) {
        List<CarEntity> carList = new ArrayList<>();

        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(file.getInputStream(),"UTF-8"))){
            CSVParser csvParser = new CSVParser(fileReader,
                    CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());{

                        Iterable<CSVRecord> csvRecord = csvParser.getRecords();

                        for (CSVRecord record : csvRecord){
                            CarEntity car = new CarEntity();

                            car.setBrand(brandRepository.findByName(record.get("brand")));

                            car.setModel(record.get("model"));
                            car.setYear(Integer.parseInt(record.get("year")));
                            car.setColour(record.get("colour"));
                            car.setMillage(Integer.parseInt(record.get("millage")));

                            carList.add(car);
                        }
                        carRepository.saveAll(carList);

            }

        } catch (Exception e) {
            log.error("Filed to load users");
            throw new RuntimeException("Failed to load users");
        }



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
