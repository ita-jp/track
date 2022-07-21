package com.pocotech.track.repository.authorities;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AuthorityRepository {

    @Insert("""
            INSERT INTO authorities (user_id, authority)
            VALUES (#{record.userId}, #{record.authority})
            """)
    void insert(@Param("record") AuthorityRecord record);
}
