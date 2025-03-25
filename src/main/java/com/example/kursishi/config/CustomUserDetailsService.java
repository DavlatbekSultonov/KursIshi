package com.example.kursishi.config;

import com.example.kursishi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        if (phoneNumber == null || phoneNumber.isBlank() || phoneNumber.isEmpty()) {
            throw new UsernameNotFoundException("Invalid phone number");
        }
        return userRepository.findByUserDetailPhoneNumber(phoneNumber).orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
    }
}

