package com.pocotech.track.repository.ticket;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TicketRepository {

    @Insert("""
            INSERT INTO tickets (summary, description)
            VALUES (#{record.summary}, #{record.description})
            """)
    @Options(
            useGeneratedKeys = true,
            keyProperty = "ticketId"
    )
    void insert(@Param("record") TicketRecord record);

    @Select("""
            SELECT
                t.ticket_id   as ticketId
              , t.summary     as summary
              , t.description as description
            FROM tickets t
            """)
    List<TicketRecord> select();
}
