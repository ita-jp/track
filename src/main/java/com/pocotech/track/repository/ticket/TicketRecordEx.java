package com.pocotech.track.repository.ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketRecordEx {

    private Long ticketId;
    private MstTicketTypeRecord type;
    private String summary;
    private String description;
    private LocalDateTime createdAt;

}
