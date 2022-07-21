package com.pocotech.track.controller.ticket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/tickets")
@Controller
public class TicketController {

    @GetMapping
    public String list() {
        return "tickets/list";
    }

    @GetMapping("/creationForm")
    public String creationForm() {
        return "tickets/creationForm";
    }
}
