package com.ojt.lms.server.service.user_impl;

import com.google.common.collect.ImmutableMap;
import com.ojt.lms.server.model.dto.User;
import com.ojt.lms.server.repo.UserRepository;
import com.ojt.lms.server.service.auth.UserAuthentication;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Optional.ofNullable;
import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

//todo: User Detail Service
@Service
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class TokenAuthenticationService implements UserAuthentication {
    @NonNull
    JwtTokenService jwtTokenService;
    @NonNull
    UserRepository userRepository;

    @NonNull
    PasswordEncoder passwordEncoder;

    @Override
    public Optional<String> login(String username, String password) {
        return ofNullable(userRepository.getUserByEmail(username))
                .filter(u -> passwordEncoder.matches(password, u.getPassword()))
                .map(user -> jwtTokenService.expiring(ImmutableMap.of("username", username)));
    }

    @Override
    public Optional<User> findUserByToken(String token) {
        return Optional.of(jwtTokenService.verify(token))
                .map(map -> map.get("username"))
                .map(userRepository::getUserByEmail);
    }
}
