package com.vitech.CarRegistry.controller;


import com.vitech.CarRegistry.services.CarService;
import com.vitech.CarRegistry.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/user")
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("downloadPhoto/{id}")
    @PreAuthorize("hasAnyRole('CLIENT','VENDOR')")
    public ResponseEntity<?> downloadUserPhoto(@PathVariable("id") Long id) {

        try {
            byte[] imageBytes = userService.getUserImage(id);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_PNG);
            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }


    @PostMapping("/userImage/{id}/add")
    @PreAuthorize("hasAnyRole('CLIENT','VENDOR')")
    public ResponseEntity<?> addProduct(@PathVariable Long id, @RequestParam("imageFile") MultipartFile imageFile) {
        try {
            if (imageFile.getOriginalFilename().contains(".png") || imageFile.getOriginalFilename().contains(".jpg")) {
                userService.addUserImage(id, imageFile);
                return ResponseEntity.ok("Image sucesfully saved");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }


}
