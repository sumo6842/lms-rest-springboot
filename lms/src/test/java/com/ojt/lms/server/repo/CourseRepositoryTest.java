package com.ojt.lms.server.repo;

import com.ojt.lms.server.model.dto.Course;
import com.ojt.lms.server.model.dto.Subject;
import com.ojt.lms.server.model.dto.User;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;

import static lombok.AccessLevel.PRIVATE;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class CourseRepositoryTest {
    @Autowired
    CourseRepository repo;
    @Autowired
    TestEntityManager em;

    @Test
    public void associatedSubjectCourseTest() {
        var subject = em.find(Subject.class, 1L);
        var course_402 = em.find(Course.class, "COURSE_402");
        repo.delete(course_402);
    }

    @Test
    public void delete() {
        var course = em.find(Course.class, "COURSE_352");
        em.remove(course);
    }

}