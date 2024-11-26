package com.vitech.CarRegistry.controller.dtos;

import com.vitech.CarRegistry.domain.Brand;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
