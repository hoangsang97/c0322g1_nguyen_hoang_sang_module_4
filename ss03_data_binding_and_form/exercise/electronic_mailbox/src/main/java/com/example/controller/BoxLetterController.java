package com.example.controller;

import com.example.model.BoxLetter;
import com.example.service.IBoxLetterService;
import com.example.service.impl.BoxLetterServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("boxLetter")
public class BoxLetterController {
    private IBoxLetterService boxLetterService = new BoxLetterServiceImpl();

    @GetMapping("showUpdate")
    public String showUpdateBox(@RequestParam int id, Model model) {
        BoxLetter boxLetter = boxLetterService.FindById(id);
        String[] languagesList = boxLetterService.languages();
        Integer[] sizeList = boxLetterService.size();
        model.addAttribute("boxLetter", boxLetter);
        model.addAttribute("languagesList", languagesList);
        model.addAttribute("sizeList", sizeList);
        return "box_letter/update";
    }

    @PostMapping("updateBox")
    public String updateBox(@ModelAttribute("boxLetter") BoxLetter boxLetter,
                            @RequestParam int id,
                            RedirectAttributes redirectAttributes) {
        boxLetterService.UpdateBox(id, boxLetter);
        redirectAttributes.addFlashAttribute("mess", "cập nhập thành công!");
        return "redirect:/boxLetter/list";
    }

    @GetMapping("list")
    public String showForm(@ModelAttribute("boxLetter") BoxLetter boxLetter, Model model) {
        List<BoxLetter> boxLetterList = boxLetterService.FindAll();
        model.addAttribute("boxLetterList", boxLetterList);
        return "box_letter/list";
    }
}
