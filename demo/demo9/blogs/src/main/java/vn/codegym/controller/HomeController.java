package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.codegym.model.Blog;
import vn.codegym.service.IBlogService;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String goHome(Model model){
        List<Blog> blogList = blogService.findAll();
        model.addAttribute("blog", blogList);
        return "blog/list";
    }
}
