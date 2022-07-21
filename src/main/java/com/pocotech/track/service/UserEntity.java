package com.pocotech.track.service;

import java.util.List;

public record UserEntity(
        long userId,
        String username,
        List<Role> roles
) {
}
