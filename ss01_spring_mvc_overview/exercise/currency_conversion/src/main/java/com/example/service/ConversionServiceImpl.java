package com.example.service;

public class ConversionServiceImpl implements IConversionService {
    @Override
    public int conversion(int usd) {
        return usd * 23000;
    }
}
