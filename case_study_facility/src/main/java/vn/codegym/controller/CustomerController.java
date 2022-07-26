package vn.codegym.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.dto.CustomerDto;
import vn.codegym.model.Customer;
import vn.codegym.model.CustomerType;
import vn.codegym.service.ICustomerService;
import vn.codegym.service.ICustomerTypeService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("showList")
    public String showList(@PageableDefault(value = 5) Pageable pageable,
                           @RequestParam String name ,Model model) {
        Page<Customer> customers = customerService.search(name, pageable);
        model.addAttribute("customer", customers);
        model.addAttribute("name", name);
        return "customer/list";
    }

    @GetMapping("showCreate")
    public String showCreate(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("customerTypeList", customerTypeList);
        return "customer/create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()){
            List<CustomerType> customerTypeList = customerTypeService.findAll();
            model.addAttribute("customerTypeList", customerTypeList);
            return "customer/create";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.create(customer);
            redirectAttributes.addFlashAttribute("mess", "Create OK");
            return "redirect:/customer/showList?name=";
        }
    }

    @GetMapping("showUpdate/{id}")
    public String showUpdate(@PathVariable int id, Model model) {
        Optional<Customer> customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("customerTypeList", customerTypeList);
        return "customer/update";
    }

    @PostMapping("update")
    public String update(@ModelAttribute Customer customer,
                         RedirectAttributes redirectAttributes) {
        customerService.update(customer);
        redirectAttributes.addFlashAttribute("mess", "Update OK");
        return "redirect:/customer/showList?name=";
    }
    @PostMapping("delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        customerService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Delete OK");
        return "redirect:/customer/showList?name=";
    }
}
