package com.pocotech.track.repository.users;

import com.pocotech.track.repository.authorities.AuthorityRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserRepository {

    @Select("""
            SELECT
                u.user_id   as user_id
              , u.username  as username
              , u.password  as password
              , a.user_id   as authority_user_id
              , a.authority as authority_authority
            FROM users u
            LEFT JOIN authorities a USING (user_id)
            WHERE u.username = #{username}
            """
    )
    @Results(value = {
            @Result(id = true, column = "user_id", property = "userId"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "enabled", property = "enabled"),
            @Result(property = "authorities", many = @Many(resultMap = "authorityResultMap", columnPrefix = "authority_"))
    })
    Optional<UserRecordEx> selectByUsername(@Param("username") String username);

    @Select("SELECT 1")
    @Results(id = "authorityResultMap", value = {
            @Result(id = true, column = "user_id", property = "userId"),
            @Result(column = "authority", property = "authority"),
    })
    AuthorityRecord __authorityResultMap();

    @Select("""
            SELECT
                u.user_id   as user_id
              , u.username  as username
              , u.password  as password
              , a.user_id   as authority_user_id
              , a.authority as authority_authority
            FROM users u
            LEFT JOIN authorities a USING (user_id)
            """)
    @Results(value = {
            @Result(id = true, column = "user_id", property = "userId"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "enabled", property = "enabled"),
            @Result(property = "authorities", many = @Many(resultMap = "authorityResultMap", columnPrefix = "authority_"))
    })
    List<UserRecordEx> selectAll();

    @Insert("""
            INSERT INTO users (username, password, enabled)
            VALUES (#{record.username}, #{record.password}, true);
            """)
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    void insert(@Param("record") UserRecord record);
}
