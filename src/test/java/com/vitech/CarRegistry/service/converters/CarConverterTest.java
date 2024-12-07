package com.vitech.CarRegistry.service.converters;


import com.vitech.CarRegistry.domain.Brand;
import com.vitech.CarRegistry.domain.Car;
import com.vitech.CarRegistry.entity.BrandEntity;
import com.vitech.CarRegistry.entity.CarEntity;
import com.vitech.CarRegistry.services.converters.BrandConverter;
import com.vitech.CarRegistry.services.converters.CarConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CarConverterTest {

    @InjectMocks
    private CarConverter carConverter;

    @Mock
    private BrandConverter brandConverter;

    @Test
    void toCar_test(){

        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName("Seat");

        CarEntity entity = new CarEntity();
        entity.setId(1);
        entity.setYear(2000);
        entity.setMillage(2000);
        entity.setModel("Arona");
        entity.setBrand(brandEntity);
        entity.setColour("red");
        entity.setDescription("desc");

        Brand brand = new Brand();
        brand.setName("Seat");

        Car car = new Car();
        car.setId(1);
        car.setYear(2000);
        car.setMillage(2000);
        car.setModel("Arona");
        car.setBrand(brand);
        car.setColour("red");
        car.setDescription("desc");

        //When
        when(brandConverter.toBrand(brandEntity)).thenReturn(brand);

        //then

         Car result = carConverter.toCar(entity);
        assertEquals(result.getId(),car.getId());
        assertEquals(result.getYear(),car.getYear());
        assertEquals(result.getModel(),car.getModel());
        assertEquals(result.getMillage(),car.getMillage());
        assertEquals(result.getColour(),car.getColour());
        assertEquals(result.getDescription(),car.getDescription());
        assertEquals(result.getBrand(),car.getBrand());




    }
}
