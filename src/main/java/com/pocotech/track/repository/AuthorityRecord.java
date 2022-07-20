package com.pocotech.track.repository;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthorityRecord {

    private long userId;
    private String authority;

}
