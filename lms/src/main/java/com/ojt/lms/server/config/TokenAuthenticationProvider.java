package com.ojt.lms.server.config;


import com.ojt.lms.server.model.dao.UserDetail;
import com.ojt.lms.server.model.dto.Course;
import com.ojt.lms.server.model.dto.User;
import com.ojt.lms.server.service.CourseHandler;
import com.ojt.lms.server.service.UserHandler;
import com.ojt.lms.server.service.auth.UserAuthentication;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;
import static lombok.AccessLevel.PRIVATE;

@Component
@AllArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
final class TokenAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
    @NonNull
    UserAuthentication userAuthentication;
    @NonNull UserHandler userHandler;
    @NonNull CourseHandler courseHandler;

    @Override
    protected void additionalAuthenticationChecks(final UserDetails userDetails,
                                                  final UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(final String username,
                                       final UsernamePasswordAuthenticationToken authentication)
                                       throws AuthenticationException {
        var param = authentication.getCredentials();
        return ofNullable(param)
                .map(String::valueOf)
                .flatMap(userAuthentication::findUserByToken)
                .stream()
                .peek(this::getCreatedCourse)
                .peek(this::enrolledCourse)
                .findAny()
                .map(UserDetail::new)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "Cannot find user with authentication " + param
                ));
    }

    private void enrolledCourse(User u) {
        var courses = courseHandler.retrieveAllCourseEnrolled(u.getId());
        u.setEnrolledCourse(courses.get());
    }

    private void getCreatedCourse(User u) {
        var courses = courseHandler.retrieveAllCourseByCreatedUser(u.getId());
        u.setCreateCourse(courses.get());
    }
}
