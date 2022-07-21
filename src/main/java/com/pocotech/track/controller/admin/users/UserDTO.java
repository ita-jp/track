package com.pocotech.track.controller.admin.users;

import java.util.List;

public record UserDTO(
        long userId,
        String username,
        List<String> roles
) {
}
