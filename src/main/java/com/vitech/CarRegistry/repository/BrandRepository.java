package com.vitech.CarRegistry.repository;

import com.vitech.CarRegistry.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<BrandEntity , Long> {

    BrandEntity findByName(String name);
}
