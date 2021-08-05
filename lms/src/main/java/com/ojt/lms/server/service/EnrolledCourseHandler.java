package com.ojt.lms.server.service;

import com.ojt.lms.server.model.dto.Course;
import com.ojt.lms.server.model.dto.User;

import java.util.List;

//todo handling on user-course table:
public interface EnrolledCourseHandler {
    //teacher:
    List<User> retrievedStudentEnrollCourse(Course course);

    //    --- generall
    void updateStatusStudentFromCourse(Long userId, Course course, boolean status);

}
