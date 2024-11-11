package com.daniel.kosk.microservices.inventoryservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service
public class FileStorageService {

    @Value("${file.upload-dir}")
    private String uploadDir;


    public String saveFile(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IOException("Sent file is empty");
        }

        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }


        Path filePath = uploadPath.resolve(file.getOriginalFilename());


        file.transferTo(filePath.toFile());

        return filePath.toString();
    }
}