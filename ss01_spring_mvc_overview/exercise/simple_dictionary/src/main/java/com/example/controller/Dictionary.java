package com.example.controller;

import com.example.service.DictionaryServiceImpl;
import com.example.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/dictionary")
public class Dictionary {

    private final IDictionaryService dictionaryService;

    public Dictionary(IDictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    @GetMapping
    public String simpleDictionary(@RequestParam(defaultValue = "0") String english, Model model) {
        String result = dictionaryService.dictionary(english);
        model.addAttribute("result", result);
        return "dictionary";
    }
}
