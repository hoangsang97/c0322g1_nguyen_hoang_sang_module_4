package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class DictionaryServiceImpl implements IDictionaryService {
    @Override
    public String dictionary(String english) {
        String result = "";
        switch (english) {
            case "hello":
                result = "Xin chào";
                break;
            case "winter":
                result = "Mùa đông";
                break;
            case "summer":
                result = "Mùa hè";
                break;
            case "spring":
                result = "Mùa xuân";
                break;
            default:
                result = "Không tìm thấy";
                break;
        }
        return result;
    }
}
