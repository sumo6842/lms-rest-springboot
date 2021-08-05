package com.ojt.lms.server.service;

import com.ojt.lms.server.model.dto.*;

import java.util.List;
import java.util.Optional;

public interface CourseHandler {
    //todo crud Course:
    Optional<Course> createOrUpdateCourse(Long id, Long subjectId);

    Optional<Course> teacherSearchOwnCourse(Long userId, Long subjectId);

    Optional<Course> retrievedCourse(String id);

    Optional<List<Course>> retrieveBySearch(String search);

    Optional<List<Course>> retrieveAllCourseByCreatedUser(Long userId);
    Optional<List<Course>> retrieveAllCourseEnrolled(Long userId);

    Optional<List<Course>> retrieveAllCourseBySubject(Long idSub);

    void deleteCourse(String courseId);

}
