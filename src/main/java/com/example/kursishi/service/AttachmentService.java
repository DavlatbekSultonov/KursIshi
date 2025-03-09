package com.example.kursishi.service;

import org.springframework.stereotype.Service;

@Service
public class AttachmentService {
    private static final String BASE_URL = "https://yourdomain.com/api/attachments/";

    public String getImageUrl(String fileName) {
        return BASE_URL + fileName; // Fayl nomi kengaytmasi bilan qaytariladi
    }
}
