package com.pocotech.track.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin/users")
@Controller
public class UserController {

    @GetMapping
    public String index() {
        return "admin/users/list";
    }
}
