package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Blog;
import vn.codegym.service.IBlogService;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("showEdit/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        Optional<Blog> blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "blog/update";
    }

    @PostMapping("edit")
    public String edit(@ModelAttribute Blog blog,
                       RedirectAttributes redirectAttributes) {
        blogService.update(blog);
        redirectAttributes.addFlashAttribute("mess", "Edit OK!");
        return "redirect:/blog/showList";
    }

    @PostMapping("delete")
    public String delete(@RequestParam int id,
                         RedirectAttributes redirectAttributes) {
        blogService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Delete OK!");
        return "redirect:/blog/showList";
    }

    @GetMapping("view")
    public String view(@RequestParam int id, Model model) {
        Optional<Blog> blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "blog/list";
    }
}
