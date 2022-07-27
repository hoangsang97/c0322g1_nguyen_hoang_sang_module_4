package com.example.cart.controller;

import com.example.cart.model.Product;
import com.example.cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeProduct {

    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String homeProduct(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("product", productList);
        return "list";
    }
}
