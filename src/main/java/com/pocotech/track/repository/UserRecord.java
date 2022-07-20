package com.pocotech.track.repository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRecord {

    private Long userId;
    private String username;
    private String password;

}
