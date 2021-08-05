package com.ojt.lms.server.service.auth;

import com.ojt.lms.server.model.dto.User;

import java.util.Optional;

public interface UserAuthentication {
    Optional<String> login(String username, String password);

    Optional<User> findUserByToken(String token);

}
