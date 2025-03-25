package com.example.kursishi.service;

import com.example.kursishi.config.JWTProvider;
import com.example.kursishi.repository.UserRepository;
import com.example.kursishi.request.AuthRequest;
import com.example.kursishi.request.AuthResponse;
import com.example.kursishi.request.ResponseData;
import com.example.kursishi.role.User;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JWTProvider jwtProvider;

    public ResponseData<?> authenticate(AuthRequest authRequest) throws EntityNotFoundException {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.phoneNumber(), authRequest.password()));

        Optional<User> byUserDetailPhoneNumber = userRepository.findByUserDetailPhoneNumber(authRequest.phoneNumber());
        if (byUserDetailPhoneNumber.isEmpty()) {
            throw new EntityNotFoundException("Not found");
        }
        User user = byUserDetailPhoneNumber.get();
        ResponseData<AuthResponse> authResponseResponseData = new ResponseData<>();
        String token = jwtProvider.generateAccessToken(user);
        AuthResponse authResponse = new AuthResponse(user, token);
        authResponseResponseData.setData(authResponse);
        authResponseResponseData.setSuccess(true);
        authResponseResponseData.setMessage("USER_FOUND");
        return ResponseData.successResponse(authResponse);
    }
}

