package com.pocotech.track.service.users;

import java.util.List;

public record UserEntity(
        long userId,
        String username,
        List<Role> roles
) {
}
