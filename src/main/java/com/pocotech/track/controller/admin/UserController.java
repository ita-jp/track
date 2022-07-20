package com.pocotech.track.controller.admin;

import com.pocotech.track.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
                .map(entity -> new UserDTO(entity.userId(), entity.username()))
                .toList();
        model.addAttribute("userList", dto);
        return "admin/users/list";
    }
}
