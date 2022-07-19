package com.example.comtroller;

import com.example.model.Listen;
import com.example.service.IListenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("listen")
public class ListenController {
    @Autowired
    private IListenService listenService;

    @GetMapping("showList")
    public String showList(Model model) {
        List<Listen> listenList = listenService.findAll();
        model.addAttribute("listen", listenList);
        return "listen/list";
    }

    @GetMapping("showCreate")
    public String showCreate(Model model) {
        model.addAttribute("listen", new Listen());
        return "listen/create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute Listen listen,
                         RedirectAttributes redirectAttributes) {
        listenService.create(listen);
        redirectAttributes.addFlashAttribute("mess", "Create OK!");
        return "redirect:/listen/showList";
    }

    @GetMapping("showEdit/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        Listen listen = listenService.findById(id);
        model.addAttribute("listen", listen);
        return "listen/update";
    }

    @PostMapping("edit/{id}")
    public String edit(@ModelAttribute Listen listen,
                       @PathVariable int id,
                       RedirectAttributes redirectAttributes) {
        listenService.update(id, listen);
        redirectAttributes.addFlashAttribute("mess", "Update OK!");
        return "redirect:/listen/showList";
    }

    @PostMapping("delete")
    public String delete(@RequestParam int id,
                         RedirectAttributes redirectAttributes) {
        listenService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Delete OK!");
        return "redirect:/listen/showList";
    }

    @GetMapping("search")
    public String search(@RequestParam String name, Model model) {
        List<Listen> listenList = listenService.search(name);
        model.addAttribute("listen", listenList);
        return "listen/list";
    }
}
