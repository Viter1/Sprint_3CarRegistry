package com.vitech.CarRegistry.controller.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BrandRequest {
    private int id;
    private String name;
    private int warranty;
    private String country;
}
