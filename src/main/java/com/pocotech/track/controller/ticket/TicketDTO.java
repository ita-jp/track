package com.pocotech.track.controller.ticket;


import java.time.LocalDateTime;

public record TicketDTO(
        long ticketId,
        String summary,
        String description,
        LocalDateTime createdAt
) {
}
