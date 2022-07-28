package com.example.controller;

import com.example.dto.CartDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("cart")
public class CartController {

    @GetMapping("showList")
    public String addToCart(@SessionAttribute(name = "cart", required = false) CartDto cartDto, Model model) {
        model.addAttribute("cart", cartDto);
        return "cartList";
    }
}
