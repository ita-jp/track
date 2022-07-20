package com.pocotech.track.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRecord {

    private Long userId;
    private String username;
    private String password;
    private boolean enable;
    private List<AuthorityRecord> authorities;

}
