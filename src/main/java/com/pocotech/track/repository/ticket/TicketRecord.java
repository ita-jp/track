package com.pocotech.track.repository.ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketRecord {

    private Long ticketId;
    private String summary;
    private String description;
    private LocalDateTime createdAt;

}
