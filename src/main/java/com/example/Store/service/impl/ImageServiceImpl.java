package com.example.Store.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.Store.entity.Image;
import com.example.Store.repository.ImageRepository;
import com.example.Store.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;

@Service
public class ImageServiceImpl implements ImageService {

    @Override
    public List<Image> getAll() {
        return imageRepository.findAll();
    }

    private static final String CLOUDINARY_URL = "cloudinary://276123242311464:R5oT9kU36JbIJqurpzev_8MPMl8@dq0y7sp3u";

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public String saveImageInCloudinary(MultipartFile multipartFile) {

        File file;

        try {
            file = Files.createTempFile(System.currentTimeMillis() + "",
                    multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().length() - 4)).toFile();
            multipartFile.transferTo(file);

            Cloudinary cloudinary = new Cloudinary(CLOUDINARY_URL);
            Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());

            return ((String) uploadResult.get("url"));


        } catch (IOException e) {
            System.out.println("ImageService.createImage: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Image saveImage(String url) {
        Image image = new Image();
        image.setUrl(url);
        return imageRepository.save(image);
    }

    @Override
    public Image saveImage(MultipartFile multipartFile) {
        String imageUrl = saveImageInCloudinary(multipartFile);
        return saveImage(imageUrl);
    }
}
