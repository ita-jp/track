package com.pocotech.track.service;

import com.pocotech.track.repository.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.selectByUsername(username)
                .map(record -> new CustomUserDetails(
                                record.getUsername(),
                                record.getPassword(),
                                List.of(
                                        new SimpleGrantedAuthority("ADMIN"),
                                        new SimpleGrantedAuthority("USER")
                                )
                        )
                )
                .orElseThrow(() -> new UsernameNotFoundException("username = " + username + " is not found"));
    }
}
