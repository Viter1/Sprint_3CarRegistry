package com.vitech.CarRegistry.services;


import com.vitech.CarRegistry.controller.dtos.JwtResponse;
import com.vitech.CarRegistry.controller.dtos.LogInRequest;
import com.vitech.CarRegistry.controller.dtos.SignUpRequest;

public interface AuthenticationService {

    public JwtResponse signup (SignUpRequest request) throws Exception;

    public JwtResponse login(LogInRequest request);
}
