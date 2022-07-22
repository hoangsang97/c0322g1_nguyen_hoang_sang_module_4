package vn.codegym.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.codegym.dto.UserDto;
import vn.codegym.model.User;
import vn.codegym.service.IUserService;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("showCreate")
    public String showCreate(Model model){
        model.addAttribute("userDto", new UserDto());
        return "create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute @Validated UserDto userDto, BindingResult bindingResult){
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            userService.create(user);
            return "redirect:/user/showList";
        }
    }

    @GetMapping("showList")
    public String showList(Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute("user", userList);
        return "list";
    }
}
