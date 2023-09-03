package com.example.crudproject.controllers;

import com.example.crudproject.entity.ImageEntity;
import com.example.crudproject.repository.ImageRepository;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;

@RequestMapping("/api/image")
@RestController
public class ImageController {

    private final ImageRepository imageRepository;

    public ImageController(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @PostMapping("/upload")
    public ResponseEntity<ImageEntity> uploadImage(@RequestParam("file") MultipartFile file, @RequestParam("name") String name) {
        try {
            String contentType = file.getContentType();
            if(contentType == null || !contentType.startsWith("image/")){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }

            byte[] imageData = file.getBytes();
            ImageEntity imageEntity = new ImageEntity();
            imageEntity.setImage(imageData);
            imageEntity.setName(name);
            imageEntity.setUploadDate(new Date());
            imageEntity.setContentType(contentType);
            imageRepository.save(imageEntity);
            return ResponseEntity.ok().body(imageEntity);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Resource> getImage(@PathVariable Long id) {
        Optional<ImageEntity> imageOptional = imageRepository.findById(id);
        if (imageOptional.isPresent()) {
            ImageEntity imageEntity = imageOptional.get();
            ByteArrayResource resource = new ByteArrayResource(imageEntity.getImage());
            HttpHeaders headers = new HttpHeaders();
            headers.setContentDisposition(ContentDisposition.builder("inline").filename(imageEntity.getName()).build());
            headers.setContentType(MediaType.parseMediaType(imageEntity.getContentType()));
            return ResponseEntity.ok().headers(headers).body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
