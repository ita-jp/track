package com.pocotech.track.service;

import com.pocotech.track.repository.authorities.AuthorityRecord;
import com.pocotech.track.repository.authorities.AuthorityRepository;
import com.pocotech.track.repository.users.UserRecord;
import com.pocotech.track.repository.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public List<UserEntity> find() {
        return userRepository.selectAll().stream()
                .map(record -> new UserEntity(
                                record.getUserId(),
                                record.getUsername(),
                                record.getAuthorities().stream()
                                        .map(AuthorityRecord::getAuthority)
                                        .map(Role::valueOf)
                                        .toList()
                        )
                )
                .collect(Collectors.toList());
    }

    @Transactional
    public void create(String username, String password, String authority) {
        var encodedPassword = passwordEncoder.encode(password);

        var userRecord = new UserRecord(null, username, encodedPassword, true);
        userRepository.insert(userRecord);

        var authorityRecord = new AuthorityRecord(userRecord.getUserId(), authority);
        authorityRepository.insert(authorityRecord);
    }
}
