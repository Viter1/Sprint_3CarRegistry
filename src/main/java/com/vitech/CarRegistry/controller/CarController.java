package com.vitech.CarRegistry.controller;


import com.vitech.CarRegistry.controller.dtos.CarRequest;
import com.vitech.CarRegistry.controller.dtos.CarResponse;
import com.vitech.CarRegistry.controller.mapper.CarMapper;
import com.vitech.CarRegistry.domain.Car;
import com.vitech.CarRegistry.services.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/cars")
@Slf4j
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private CarMapper carMapper;

    @GetMapping ("/{id}")
    @PreAuthorize("hasAnyRole('CLIENT','VENDOR')")
    public ResponseEntity<?> getCarById(@PathVariable Integer id){
    log.info("Retriving Car Info - get car");
        try {
        return ResponseEntity.ok(carService.getCarById(id));
        } catch (Exception e) {
        return  ResponseEntity.notFound().build();
        }

    }

    @GetMapping ("/findAll")
    @PreAuthorize("hasAnyRole('CLIENT','VENDOR')")
    public CompletableFuture<?> getCars(){
        log.info("Retriving Car Info - get car");
        log.info(":D");
        try {
            CompletableFuture<List<Car>> cars = carService.getAllCars();
            List< CarResponse> response = new ArrayList<>();

            cars.get().forEach(car -> {

                response.add(carMapper.toResponse(car));
                log.info(":D");
            });
            return CompletableFuture.completedFuture(response);
        } catch (Exception e) {
            return  CompletableFuture.completedFuture(ResponseEntity.notFound());
        }

    }



    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('VENDOR')")
    public ResponseEntity<?> deleteCarById(@PathVariable Integer id){
        log.info("Retriving Car Info - delete");
        try {
            carService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return  ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('VENDOR')")
    public ResponseEntity<?> addCar (@RequestBody CarRequest carRequest) {
        log.info("Retriving Car Info - add car");
        try {
            carService.saveCar(carMapper.toModel(carRequest));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return  ResponseEntity.notFound().build();
        }

    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('VENDOR')")
    public ResponseEntity<?> updateCarById (@PathVariable Integer id , @RequestBody CarRequest carRequest) {
        log.info("Retriving Car Info - update car");
        try {
            carService.updateById(id , carMapper.toModel(carRequest));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return  ResponseEntity.notFound().build();
        }

    }





}
