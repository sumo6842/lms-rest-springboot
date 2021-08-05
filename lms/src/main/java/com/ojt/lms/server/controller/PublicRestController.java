package com.ojt.lms.server.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ojt.lms.server.model.dao.UserDetail;
import com.ojt.lms.server.model.dto.User;
import com.ojt.lms.server.service.auth.UserAuthentication;
import com.ojt.lms.server.service.UserHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@RestController
@Api(tags = "Login/Create")
@RequestMapping("/api/public")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor(access = PACKAGE)
public class PublicRestController {
    @NonNull
    UserAuthentication userAuthentication;
    @NonNull
    UserHandler service;

    class EntityLogin {
        @JsonProperty("access_token")
        private String token;
        @JsonProperty("user")
        private UserDetail user;

        public EntityLogin(String token, UserDetail user) {
            this.token = token;
            this.user = user;
        }
    }

    @ApiOperation(value = "login")
    @PostMapping("/login")
    ResponseEntity<EntityLogin> login(@RequestParam("username") final String username,
                                     @RequestParam("password") final String password) {
        var token = userAuthentication
                .login(username, password)
                .orElseThrow(() -> new RuntimeException("invalid login and/or password"));
        return userAuthentication.findUserByToken(token)
                .map(UserDetail::new)
                .map(u -> new EntityLogin(token,u))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(404).build());
    }

    @ApiOperation(value = "request with full field user to register account")
    @PostMapping("/create")
    User createUser(@RequestBody User user) {
        return service.updateUser(user);
    }

}
