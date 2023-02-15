package com.example.blogbackend.controller;

import com.example.blogbackend.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/images")
public class ImageController {


    @Autowired
    private ImageService imageService;

    //Lấy danh sách ảnh của User
    @GetMapping("")
    public ResponseEntity<?> getAllImage() {
        return ResponseEntity.ok(imageService.getAllImage());
    }

    //Xemm ảnh
    @GetMapping("{id}")
    public  ResponseEntity<?> readImages(@PathVariable Integer id) {
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(imageService.readImage(id));

    }
    //Upload Ảnh
    @PostMapping("")
    public ResponseEntity<?> uploadImage(@ModelAttribute("file")MultipartFile file) {
        return new ResponseEntity<>(imageService.uploadImage(file), HttpStatus.CREATED);
    }

    // Xóa ảnh
    @DeleteMapping("{id}")
    public  ResponseEntity<?> deleteImage(@PathVariable Integer id) {
        imageService.deleteImage(id);
        return ResponseEntity.noContent().build();
    }

}
