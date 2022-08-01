package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.codegym.model.Category;
import vn.codegym.service.ICategoryService;

@Controller
public class HomeController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String goHome(@PageableDefault(value = 2) Pageable pageable, Model model) {
        Page<Category> categories = categoryService.findAll(pageable);
        model.addAttribute("category", categories);
        return "blog/category/list";
    }
}
