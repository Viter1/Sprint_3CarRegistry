package com.vitech.CarRegistry.repository;

import com.vitech.CarRegistry.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {

    Optional<UserEntity> findByMail(String mail);


}
