package com.vitech.CarRegistry.services;

import com.vitech.CarRegistry.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserService {

    public UserEntity save(UserEntity entity);

    byte[] getUserImage(Long id);

    void addUserImage(Long id , MultipartFile file) throws IOException;

}
