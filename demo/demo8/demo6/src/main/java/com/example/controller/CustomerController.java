package com.example.controller;

import com.example.model.Customer;
import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("showList")
    public String showList(Model model) {
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customer", customerList);
        return "customer/list";
    }

    @GetMapping("showCreate")
    public String showCreate(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute Customer customer,
                         RedirectAttributes redirectAttributes) {
        customerService.create(customer);
        redirectAttributes.addFlashAttribute("mess", "Create OK!");
        return "redirect:/customer/showList";
    }

    @GetMapping("showEdit/{id}")
    public String showEdit(@PathVariable int id, Model model){
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "customer/update";
    }

    @PostMapping("edit/{id}")
    public String edit(@ModelAttribute Customer customer,
                       @PathVariable int id,
                       RedirectAttributes redirectAttributes) {
        customerService.update(id, customer);
        redirectAttributes.addFlashAttribute("mess", "Edit Ok!");
        return "redirect:/customer/showList";
    }

    @PostMapping("delete")
    public String delete(@RequestParam int id,
                         RedirectAttributes redirectAttributes){
        customerService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Delete OK");
        return "redirect:/customer/showList";
    }

    @GetMapping("search")
    public String search(@RequestParam String name, Model model) {
       List<Customer> customer = customerService.search(name);
       model.addAttribute("customer", customer);
       return "customer/list";
    }
}
