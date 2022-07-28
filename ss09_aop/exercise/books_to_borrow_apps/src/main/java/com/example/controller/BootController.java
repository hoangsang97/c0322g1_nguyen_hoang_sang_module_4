package com.example.controller;

import com.example.model.Boot;
import com.example.model.Borrow;
import com.example.model.OrderBorrow;
import com.example.service.IBootService;
import com.example.service.IBorrowService;
import com.example.service.IOrderBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("boot")
public class BootController {

    @Autowired
    private IBootService bootService;

    @Autowired
    private IBorrowService borrowService;

    @Autowired
    private IOrderBorrowService orderBorrowService;

    @GetMapping("showList")
    public String showList(@PageableDefault Pageable pageable, Model model) throws Exception {
        Page<Boot> boots = bootService.findAll(pageable);
        model.addAttribute("boot", boots);
        List<Borrow> borrowList = borrowService.findAll();
        model.addAttribute("borrow", borrowList);
        model.addAttribute("orderBorrow", new OrderBorrow());
        model.addAttribute("borrows", new Borrow());
        if (1 == 1) {
            throw new Exception();
        }
        return "list";
    }

    @PostMapping("create")
    public String create(@ModelAttribute OrderBorrow orderBorrow,
                         RedirectAttributes redirectAttributes) {
        orderBorrowService.create(orderBorrow);
        bootService.updateAmount(orderBorrow.getBoot().getId());
        redirectAttributes.addFlashAttribute("mess", "Borrow OK");
        return "redirect:/boot/showList";
    }

    @PostMapping("payBoot")
    public String payBoot(@ModelAttribute Borrow borrow) {
        bootService.payAmount(borrow.getId());
        return "redirect:/boot/showList";
    }
}
