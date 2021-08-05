package com.ojt.lms.server.service;

import com.ojt.lms.server.model.dto.Course;
import com.ojt.lms.server.model.dto.Role;
import com.ojt.lms.server.model.dto.User;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

//todo handling on User table:
public interface UserHandler {

    List<User> retrievedAllUser();

    Optional<List<User>> retrievedUser(String search);

    Optional<User> retrieveUserById(Long id);

    User updateUser(User user);

    void updateStatus(Long userId, boolean status);

    void deletedUser(Long id);
//
    Optional<List<User>> getAllUserEnrolledCourse(String courseId);

    Optional<Course> enrollCourse(Long id, String courseId);

    void unEnrolledCourse(Long userId, String courseId);
}
