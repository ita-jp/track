package com.pocotech.track.controller.admin;

import java.util.List;

public record UserDTO(
        long userId,
        String username,
        List<String> roles
) {
}
