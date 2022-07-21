package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Blog;
import vn.codegym.model.Category;
import vn.codegym.service.IBlogService;
import vn.codegym.service.ICategoryService;

import java.util.Optional;

@Controller
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("showList")
    public String showList(@PageableDefault(value = 2)Pageable pageable, Model model){
        Page<Category> categories = categoryService.findAll(pageable);
        model.addAttribute("category", categories);
        return "blog/category/list";
    }

    @GetMapping("showCreate")
    public String showCreate(Model model) {
        model.addAttribute("category", new Category());
        return "blog/category/create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute Category category,
                         RedirectAttributes redirectAttributes) {
        categoryService.create(category);
        redirectAttributes.addFlashAttribute("mess", "Create OK!");
        return "redirect:/category/showList";
    }

    @GetMapping("showViewBlog")
    public String viewBlog(){
        return "redirect:/blog/showList";
    }

    @GetMapping("showEdit/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        Optional<Category> category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "blog/category/update";
    }

    @PostMapping("edit")
    public String edit(@ModelAttribute Category category,
                       RedirectAttributes redirectAttributes) {
        categoryService.update(category);
        redirectAttributes.addFlashAttribute("mess", "Edit OK!");
        return "redirect:/category/showList";
    }

    @PostMapping("delete")
    public String delete(@RequestParam int id,
                         RedirectAttributes redirectAttributes) {
        categoryService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Delete OK!");
        return "redirect:/category/showList";
    }
}
