package com.example.controller;

import com.example.model.Person;
import com.example.service.IPersonService;
import com.example.service.impl.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("person")
public class PersonController {
    private IPersonService personService = new PersonService();

    @GetMapping("list")
    public String showList(Model model) {
        List<Person> personList = personService.findAll();
        model.addAttribute("personList", personList);
        return "list";
    }

    @GetMapping("showCreate")
    public String showCreate(Model model) {
        model.addAttribute("person", new Person());
        return "create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute Person person) {
        personService.create(person);
        return "redirect:/person/list";
    }

    @GetMapping("showUpdate")
    public String showUpdate(@RequestParam int id, Model model) {
        Person person = personService.FindById(id);
        model.addAttribute("person", person);
        return "update";
    }

    @PostMapping("update")
    public String update(@ModelAttribute Person person,
                         @RequestParam int id) {
        personService.update(id, person);
        return "redirect:/person/list";
    }
}
