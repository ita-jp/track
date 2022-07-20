package com.pocotech.track.service;

import com.pocotech.track.repository.UserRecord;
import com.pocotech.track.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<UserEntity> find() {
        return userRepository.selectAll().stream()
                .map(record -> new UserEntity(record.getUserId(), record.getUsername()))
                .collect(Collectors.toList());
    }

    public void create(String username, String password, String authority) {
        var encodedPassword = passwordEncoder.encode(password);
        var record = new UserRecord(null, username, encodedPassword);
        userRepository.insert(record);
    }
}
