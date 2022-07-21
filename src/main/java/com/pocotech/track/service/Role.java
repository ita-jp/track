package com.pocotech.track.service;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public enum Role {

    ADMIN(List.of(Permission.READ_USER, Permission.WRITE_USER)),
    USER(List.of());

    private final List<Permission> permissions;

}
