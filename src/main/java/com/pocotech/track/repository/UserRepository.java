package com.pocotech.track.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface UserRepository {

    @Select("""
            SELECT
                u.user_id
              , u.username
              , u.password
            FROM users u
            WHERE u.username = #{username}
            """
    )
    Optional<UserRecord> selectByUsername(@Param("username") String username);
}
