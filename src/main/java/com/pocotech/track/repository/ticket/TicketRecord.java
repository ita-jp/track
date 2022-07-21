package com.pocotech.track.repository.ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketRecord {

    private Long ticketId;
    private String summary;
    private String description;

}
