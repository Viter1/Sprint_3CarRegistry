package com.vitech.CarRegistry.controller.dtos;

import com.vitech.CarRegistry.domain.Brand;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarResponse {
    private Integer id;

    private BrandResponse brand;
    private String model;
    private Integer millage;
    private Double price;
    private Integer year;
    private String description;
    private String colour;
    private String fueltype;
    private String numDoors;
}
