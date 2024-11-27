package com.vitech.CarRegistry.controller;


import com.vitech.CarRegistry.controller.dtos.JwtResponse;
import com.vitech.CarRegistry.controller.dtos.LogInRequest;
import com.vitech.CarRegistry.controller.dtos.SignUpRequest;
import com.vitech.CarRegistry.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<JwtResponse> signup(@RequestBody SignUpRequest request) {
        try {
            return ResponseEntity.ok(authenticationService.signup(request));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login (@RequestBody LogInRequest request){
        try{
            return ResponseEntity.ok(authenticationService.login(request));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
}
