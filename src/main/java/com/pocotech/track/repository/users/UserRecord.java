package com.pocotech.track.repository.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRecord {

    private Long userId;
    private String username;
    private String password;
    private boolean enable;

}
