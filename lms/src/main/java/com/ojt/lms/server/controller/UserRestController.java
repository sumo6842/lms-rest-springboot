package com.ojt.lms.server.controller;

import com.ojt.lms.server.model.dao.UserDetail;
import com.ojt.lms.server.service.CourseHandler;
import com.ojt.lms.server.service.UserHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping(value = "/api/general")
@Api(tags = "Current User")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor(access = PACKAGE)
public class UserRestController {

    @ApiOperation(value = "This method is used to get" +
            " information after authorization")
    @GetMapping("/user")
    ResponseEntity<UserDetail> getCurrent(
            @AuthenticationPrincipal final UserDetail user) {

        return ResponseEntity.ok(user);
    }
}
