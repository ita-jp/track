package com.pocotech.track.repository.ticket;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TicketRepository {

    @Insert("""
            INSERT INTO tickets (mst_ticket_types_id, summary, description, created_at)
            VALUES (#{record.type}, #{record.summary}, #{record.description}, #{record.createdAt})
            """)
    @Options(useGeneratedKeys = true, keyProperty = "ticketId")
    void insert(@Param("record") TicketRecord record);

    @Select("""
            SELECT
                t.ticket_id             AS ticketId
              , t.summary               AS summary
              , t.description           AS description
              , t.created_at            AS createdAt
              , mtt.mst_ticket_types_id AS mtt_mst_ticket_types_id
              , mtt.name                AS mtt_name
            FROM tickets t
            JOIN mst_ticket_types mtt USING (mst_ticket_types_id)
            """)
    @Results(value = {
            @Result(property = "ticketId", column = "ticketId", id = true),
            @Result(property = "summary", column = "summary"),
            @Result(property = "description", column = "description"),
            @Result(property = "createdAt", column = "createdAt"),
            @Result(property = "type", one = @One(resultMap = "__mstTicketTypeResultMap", columnPrefix = "mtt_")),
    })
    List<TicketRecordEx> select();

    @Select("SELECT 1")
    @Results(id = "__mstTicketTypeResultMap", value = {
            @Result(property = "mstTicketTypesId", column = "mst_ticket_types_id", id = true),
            @Result(property = "name", column = "name")
    })
    MstTicketTypeRecord __mstTicketTypeResultMap();
}
