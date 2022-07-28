package com.example.controller;

import com.example.dto.CartDto;
import com.example.dto.ProductDto;
import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
    private CartDto cartDto() {
        return new CartDto();
    }

    @Autowired
    private IProductService productService;

    @GetMapping("showList")
    public String showList(Model model, @CookieValue(value = "idProduct", defaultValue = "-1") int idProduct) throws Exception {
        if (idProduct != -1) {
            Product product = productService.findById(idProduct).get();
            model.addAttribute("historyProduct", product);
        }

        List<Product> productList = productService.findAll();
        model.addAttribute("product", productList);
        return "list";
    }

    @GetMapping("add/{id}")
    public String addToCart(@PathVariable int id, @SessionAttribute(name = "cart", required = false) CartDto cartDto) {
        Optional<Product> productList = productService.findById(id);
        if (productList.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productList, productDto);

            cartDto.addProduct(productDto);
        }

        return "redirect:/cart/showList";
    }

    @GetMapping("detail/{id}")
    public String productDetail(@PathVariable int id, Model model,
                                HttpServletResponse response) {
//        return new ModelAndView( "productDetail","product", productService.findById(id).get());
        Cookie cookie = new Cookie("idProduct", id + "");
        cookie.setPath("/");
        cookie.setMaxAge(24);
        response.addCookie(cookie);

        //Đối tượng optional bắt buộc phải .get() để lấy thuộc tính findById.
        Product product = productService.findById(id).get();
        model.addAttribute("product", product);
        return "productDetail";
    }
}
