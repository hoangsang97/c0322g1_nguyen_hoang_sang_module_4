package vn.codegym.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.dto.ProductDto;
import vn.codegym.model.Product;
import vn.codegym.service.IProductService;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("showList")
    public String showList(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("product", productList);
        return "product/list";
    }

    @GetMapping("showCreate")
    public String showCreate(Model model) {
        model.addAttribute("productDto", new ProductDto());
        return "product/create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute @Validated ProductDto productDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        new ProductDto().validate(productDto, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "product/create";
        } else {
            Product product = new Product();
            BeanUtils.copyProperties(productDto, product);
            productService.create(product);
            redirectAttributes.addFlashAttribute("mess", "Create OK!");
            return "redirect:/product/showList";
        }
    }
}
