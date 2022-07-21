package com.pocotech.track.service.ticket;

import java.time.LocalDateTime;

public record TicketEntity(
        long ticketId,
        String type,
        String summary,
        String description,
        LocalDateTime createdAt
) {
}
