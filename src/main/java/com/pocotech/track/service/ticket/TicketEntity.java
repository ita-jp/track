package com.pocotech.track.service.ticket;

public record TicketEntity(
        long ticketId,
        String summary,
        String description
) {
}
