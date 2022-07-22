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
import vn.codegym.dto.ListenDto;
import vn.codegym.model.Listen;
import vn.codegym.service.IListenService;

import java.util.Optional;

@Controller
@RequestMapping("listen")
public class ListenController {
    @Autowired
    private IListenService listenService;

    @GetMapping("showList")
    public String showList(@PageableDefault(value = 2) Pageable pageable, Model model) {
        Page<Listen> listenList = listenService.findAll(pageable);
        model.addAttribute("listen", listenList);
        return "listen/list";
    }

    @GetMapping("showCreate")
    public String showCreate(Model model) {
        model.addAttribute("listenDto", new ListenDto());
        return "listen/create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute @Validated ListenDto listenDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        new ListenDto().validate(listenDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "listen/create";
        } else {
            Listen listen = new Listen();
            BeanUtils.copyProperties(listenDto, listen);
            listenService.create(listen);
            redirectAttributes.addFlashAttribute("mess", "Create OK!");
            return "redirect:/listen/showList";
        }
    }

    @GetMapping("showEdit/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        Optional<Listen> listen = listenService.findById(id);
        model.addAttribute("listen", listen);
        return "listen/update";
    }

    @PostMapping("edit")
    public String edit(@ModelAttribute Listen listen,
                       RedirectAttributes redirectAttributes) {
        listenService.update(listen);
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
    public String search(@PageableDefault(value = 2) Pageable pageable, @RequestParam String name, Model model) {
        Page<Listen> listenPage = listenService.search(name, pageable);
        model.addAttribute("listen", listenPage);
        return "listen/list";
    }
}
