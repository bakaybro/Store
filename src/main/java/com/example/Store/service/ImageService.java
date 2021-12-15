package com.example.Store.service;

import com.example.Store.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    List<Image> getAll();
    String saveImageInCloudinary(MultipartFile multipartFile);
    Image saveImage(String url);
    Image saveImage(MultipartFile multipartFile);
}
