package com.pocotech.track.repository.authorities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorityRecord {

    private long userId;
    private String authority;

}
