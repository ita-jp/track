package com.pocotech.track.controller.ticket;

import com.pocotech.track.service.ticket.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/tickets")
@Controller
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @GetMapping
    public String list(Model model) {
        var dtoList = ticketService.find()
                .stream()
                .map(e -> new TicketDTO(e.ticketId(), e.summary(), e.description(), e.createdAt()))
                .toList();
        model.addAttribute("ticketList", dtoList);
        return "tickets/list";
    }

    @GetMapping("/creationForm")
    public String showCreationForm(@ModelAttribute TicketForm ticketForm) {
        return "tickets/creationForm";
    }

    @PostMapping
    public String create(@Validated TicketForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return showCreationForm(form);
        }
        ticketService.create(form.getSummary(), form.getDescription());
        return "redirect:/tickets";
    }
}
