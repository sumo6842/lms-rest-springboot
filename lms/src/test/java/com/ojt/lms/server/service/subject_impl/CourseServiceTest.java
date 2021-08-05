package com.ojt.lms.server.service.subject_impl;

import com.ojt.lms.server.model.dto.Course;
import com.ojt.lms.server.model.dto.Subject;
import com.ojt.lms.server.model.dto.User;
import com.ojt.lms.server.service.user_impl.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseServiceTest {
    @Autowired
    CourseService courseService;
    @Autowired
    UserService userService;
    @Autowired
    SubjectService subjectService;

    @Test
    void createOrUpdateCourse() {
        var user = userService.retrieveUserById(13L);
        var subById = subjectService.getSubById(10L);
        var course = new Course(subById.get());
        courseService.createOrUpdateCourse(12L, 13L);
        System.out.println(user);
    }

    @Test
    void retrievedCourse() {
        var course_001 = courseService.retrievedCourse("COURSE_001");
        System.out.println(course_001.get());
    }

    @Test
    void retrieveBySearch() {
        var course = courseService.retrieveBySearch("COURSE");
        course.stream().forEach(System.out::println);
    }

    @Test
    void retrieveAllCourseByCreatedUser() {
//        var user = userService.retrieveUserById(13L);
        var courses = courseService.retrieveAllCourseByCreatedUser(13L);
        courses.get().forEach(System.out::println);
    }

    @Test
    void retrieveAllCourseBySubject() {
        var subById = subjectService.getSubById(10L);
//        var courses = courseService.retrieveAllCourseBySubject();
//        courses.stream().forEach(System.out::println);

    }

    @Test
    void deleteCourse() {
        courseService.deleteCourse("COURSE_052");
    }

    @Test
    void getEnrolledCourse() {
        System.out.println("All course");
        courseService.retrieveAllCourseEnrolled(4L).stream().forEach(System.out::println);
    }
}