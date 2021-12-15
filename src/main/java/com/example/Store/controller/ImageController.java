package com.example.Store.controller;

import com.example.Store.entity.Image;
import com.example.Store.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/get-all")
    public List<Image> getAll() {
        return imageService.getAll();
    }

    @PostMapping("/save")
    public Image saveImage(@RequestParam(name = "file") MultipartFile file) {
        return imageService.saveImage(file);
    }
}
