package com.example.cart.controller;

import com.example.cart.dto.CartDto;
import com.example.cart.dto.ProductDto;
import com.example.cart.model.Product;
import com.example.cart.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("product")
@SessionAttributes("cart")
public class ProductController {

    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();
    }

    @Autowired
    private IProductService productService;

    @GetMapping("showList")
    public String showList(Model model, @CookieValue(value = "idProduct", defaultValue = "-1") int idProduct){
        if (idProduct != -1) {
            Product product = productService.findById(idProduct).get();
            model.addAttribute("historyProduct", product);
        }

        List<Product> productList = productService.findAll();
        model.addAttribute("product", productList);
        return "list";
    }

    @GetMapping("add/{id}")
    public String addToCart(@PathVariable int id,
                            @SessionAttribute(value = "cart", required = false) CartDto cart) {
        Optional<Product> productDetail = productService.findById(id);
        if (productDetail.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productDetail.get(), productDto);

            cart.addProduct(productDto);
        }

        return "redirect:/cart/showList";
    }

    @GetMapping("productDetail/{id}")
    public String productDetail(@PathVariable int id, Model model,
                                HttpServletResponse response) {
        Cookie cookie = new Cookie("idProduct", id + "");
        cookie.setMaxAge(1*24*60*60);
        cookie.setPath("/");
        response.addCookie(cookie);

        Product product = productService.findById(id).get();
        model.addAttribute("product", product);
        return "productDetail";
    }
}
