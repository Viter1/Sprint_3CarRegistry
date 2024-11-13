package com.vitech.CarRegistry.services.converters;

import com.vitech.CarRegistry.domain.Brand;
import com.vitech.CarRegistry.entity.BrandEntity;
import org.springframework.stereotype.Component;

@Component
public class BrandConverter {

    public Brand toBrand(BrandEntity entity){
        Brand brand = new Brand();
        brand.setId(entity.getId());
        brand.setName(entity.getName());
        brand.setCountry(entity.getCountry());

         return brand;
    }

    public BrandEntity toEntity (Brand brand){
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setId(brand.getId());
        brandEntity.setName(brand.getName());
        brandEntity.setCountry(brand.getCountry());

        return brandEntity;
    }


}
