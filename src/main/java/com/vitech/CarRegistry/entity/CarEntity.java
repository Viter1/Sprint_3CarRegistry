package com.vitech.CarRegistry.entity;



import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "car")
public class CarEntity {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private BrandEntity brand;

    private String model;
    private Integer millage;
    private Double price;
    private Integer year;
    private String description;
    private String colour;
    private String fueltype;
    private String numDoors;
}