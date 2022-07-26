package com.pocotech.track.repository.ticket;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class TicketRecord {

    private Long ticketId;
    private long type;
    private String summary;
    private String description;
    private LocalDateTime createdAt;

}

