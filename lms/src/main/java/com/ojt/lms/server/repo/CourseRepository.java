package com.ojt.lms.server.repo;

import com.ojt.lms.server.model.dto.Course;
import com.ojt.lms.server.model.dto.Subject;
import com.ojt.lms.server.model.dto.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends CrudRepository<Course, String> {
    Optional<List<Course>> findCourseByCreatedUser(User user);

    Optional<List<Course>> findCourseBySubject(Subject subject);

    @Query("SELECT c FROM Course c WHERE c.courseID LIKE %:search%")
    Optional<List<Course>> searchCourse(String search);

}
