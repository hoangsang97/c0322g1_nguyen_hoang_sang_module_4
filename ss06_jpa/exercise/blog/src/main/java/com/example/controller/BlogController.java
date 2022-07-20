package com.example.controller;

import com.example.model.Blog;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping("showList")
    public String showList(Model model) {
        List<Blog> blogList = blogService.findAll();
        model.addAttribute("blog", blogList);
        return "blog/list";
    }

    @GetMapping("showCreate")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "blog/create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute Blog blog,
                         RedirectAttributes redirectAttributes) {
        blogService.create(blog);
        redirectAttributes.addFlashAttribute("mess", "Create OK!");
        return "redirect:/blog/showList";
    }
}
