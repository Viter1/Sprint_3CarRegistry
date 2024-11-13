package com.vitech.CarRegistry.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class  Brand {
    private int id;
    private String name;
    private int warranty;
    private String country;
}
