package com.pocotech.track.service.ticket;

import com.pocotech.track.repository.ticket.TicketRecord;
import com.pocotech.track.repository.ticket.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    @Transactional
    public void create(String summary, String description) {
        var record = new TicketRecord(null, summary, description);
        ticketRepository.insert(record);
    }

    public List<TicketEntity> find() {
        return ticketRepository.select()
                .stream()
                .map(r -> new TicketEntity(r.getTicketId(), r.getSummary(), r.getDescription()))
                .toList();
    }
}
