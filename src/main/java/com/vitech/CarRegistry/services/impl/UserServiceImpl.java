package com.vitech.CarRegistry.services.impl;

import com.vitech.CarRegistry.entity.UserEntity;
import com.vitech.CarRegistry.repository.UserRepository;
import com.vitech.CarRegistry.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserEntity save(UserEntity entity) {
        return userRepository.save(entity);
    }
}
