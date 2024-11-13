package com.vitech.CarRegistry.entity;



import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "brand")
public class BrandEntity {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private int warranty;
    private String country;

    @OneToMany(mappedBy = "brand")
    List<CarEntity> car;




}
