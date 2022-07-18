package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        model.addAttribute("product", new Product());
        model.addAttribute("productDescribe", productService.productDescribe());
        return "product/create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute Product product,
                         RedirectAttributes redirectAttributes) {
        productService.create(product);
        redirectAttributes.addFlashAttribute("mess", "Create OK!");
        return "redirect:/product/showList";
    }

    @GetMapping("showEdit/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        Product product = productService.FindById(id);
        model.addAttribute("product", product);
        model.addAttribute("productDescribe", productService.productDescribe());
        return "product/update";
    }

    @PostMapping("edit/{id}")
    public String edit(@ModelAttribute Product product,
                       @PathVariable int id,
                       RedirectAttributes redirectAttributes) {
        productService.update(id, product);
        redirectAttributes.addFlashAttribute("mess", "Edit OK!");
        return "redirect:/product/showList";
    }

    @GetMapping("search")
    public String search(@RequestParam String name, Model model) {
        List<Product> productList = productService.search(name);
        model.addAttribute("product", productList);
        return "product/list";
    }

    @PostMapping("delete")
    public String delete(@RequestParam int id,
                         RedirectAttributes redirectAttributes) {
        productService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Delete Ok!");
        return "redirect:/product/showList";
    }
}
