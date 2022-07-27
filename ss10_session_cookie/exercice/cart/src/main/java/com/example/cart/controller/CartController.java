package com.example.cart.controller;

import com.example.cart.dto.CartDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("cart")
public class CartController {

    @GetMapping("showList")
    public String showList(@SessionAttribute(name = "cart") CartDto cartDto, Model model) {
        model.addAttribute("cart", cartDto);
        return "cartList";
    }
}
