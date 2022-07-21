package com.pocotech.track.controller.admin;

import com.pocotech.track.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;

@RequestMapping("/admin/users")
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public String index(Model model) {
        var dto = userService.find().stream()
                .map(entity -> new UserDTO(
                        entity.userId(),
                        entity.username(),
                        entity.roles().stream()
                                .map(Enum::name)
                                .collect(Collectors.toList()))
                )
                .toList();
        model.addAttribute("userList", dto);
        return "admin/users/list";
    }

    @GetMapping("/creationForm")
    public String showCreationForm(@ModelAttribute UserForm form) {
        return "admin/users/creationForm";
    }

    @PostMapping
    public String create(@Validated UserForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return showCreationForm(form);
        }
        userService.create(form.getUsername(), form.getPassword(), form.getAuthority());
        return "redirect:/admin/users";
    }
}
