package com.pocotech.track.service;

import com.pocotech.track.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserEntity> find() {
        return userRepository.selectAll().stream()
                .map(record -> new UserEntity(record.getUserId(), record.getUsername()))
                .collect(Collectors.toList());
    }
}
