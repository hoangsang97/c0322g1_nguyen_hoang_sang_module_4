package com.example.service;

import com.example.model.Customer;
import javafx.scene.shape.CubicCurve;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
}
