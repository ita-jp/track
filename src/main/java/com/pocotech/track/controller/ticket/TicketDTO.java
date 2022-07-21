package com.pocotech.track.controller.ticket;


public record TicketDTO(
        long ticketId,
        String summary,
        String description
) {
}
