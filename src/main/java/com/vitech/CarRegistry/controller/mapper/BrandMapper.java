package com.vitech.CarRegistry.controller.mapper;

import com.vitech.CarRegistry.controller.dtos.BrandRequest;
import com.vitech.CarRegistry.controller.dtos.BrandResponse;
import com.vitech.CarRegistry.domain.Brand;
import org.springframework.stereotype.Component;

@Component
public class BrandMapper {

    public BrandResponse toResponse(Brand entity){
        BrandResponse brand = new BrandResponse();
        brand.setId(entity.getId());
        brand.setName(entity.getName());
        brand.setCountry(entity.getCountry());

        return brand;
    }

    public Brand toModel(BrandRequest request){
        Brand brand = new Brand();

        brand.setId(request.getId());
        brand.setName(request.getName());
        brand.setCountry(request.getCountry());

        return brand;
    }


}
