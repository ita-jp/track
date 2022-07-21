package com.pocotech.track.service.ticket;

import com.pocotech.track.repository.ticket.TicketRecord;
import com.pocotech.track.repository.ticket.TicketRecordEx;
import com.pocotech.track.repository.ticket.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    @Transactional
    public void create(long type, String summary, String description) {
        var record = new TicketRecord(null, type, summary, description, LocalDateTime.now());
        ticketRepository.insert(record);
    }

    public List<TicketEntity> find() {
        return ticketRepository.select()
                .stream()
                .map(r -> new TicketEntity(
                        r.getTicketId(),
                        r.getType().getName(),
                        r.getSummary(),
                        r.getDescription(),
                        r.getCreatedAt()
                ))
                .toList();
    }

    public Optional<TicketEntity> find(long ticketId) {
        return ticketRepository.selectByTicketId(ticketId)
                .map(r -> new TicketEntity(
                        r.getTicketId(),
                        r.getType().getName(),
                        r.getSummary(),
                        r.getDescription(),
                        r.getCreatedAt()
                ));
    }
}
