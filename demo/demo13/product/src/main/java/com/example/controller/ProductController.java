package com.example.controller;

import com.example.dto.CartDto;
import com.example.dto.ProductDto;
import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("product")
@SessionAttributes("cart")
public class ProductController {

    @ModelAttribute("cart")
    public CartDto cartDto() {
        return new CartDto();
    }

    @Autowired
    private IProductService productService;

    @GetMapping("showList")
    public String showList(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("product", productList);
        return "list";
    }

    @GetMapping("add/{id}")
    public String addToCart(@PathVariable int id, @SessionAttribute("cart") CartDto cartDto) {
        Optional<Product> productList = productService.findById(id);
        if (productList.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productList, productDto);

            cartDto.addProduct(productDto);
        }

        return "redirect:/cart/showList";
    }

}
