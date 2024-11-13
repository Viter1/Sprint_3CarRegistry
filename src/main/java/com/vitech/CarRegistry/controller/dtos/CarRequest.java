package com.vitech.CarRegistry.controller.dtos;


import com.vitech.CarRegistry.domain.Brand;
import lombok.Data;

@Data
public class CarRequest {

    private Integer id;

    private BrandRequest brand;
    private String model;
    private Integer millage;
    private Double price;
    private Integer year;
    private String description;
    private String colour;
    private String fueltype;
    private String numDoors;
}
