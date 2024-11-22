package com.vitech.CarRegistry.services;

import com.vitech.CarRegistry.entity.UserEntity;
import org.apache.catalina.User;

public interface UserService {

    public UserEntity save(UserEntity entity);
}
