package com.ojt.lms.server.service.subject_impl;

import com.ojt.lms.server.model.dto.Course;
import com.ojt.lms.server.model.dto.Subject;
import com.ojt.lms.server.model.dto.User;
import com.ojt.lms.server.repo.CourseRepository;
import com.ojt.lms.server.service.CourseHandler;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;
import static lombok.AccessLevel.PRIVATE;

@Service
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor
public class CourseService implements CourseHandler {
    @NonNull
    CourseRepository repo;

    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public Optional<Course> createOrUpdateCourse(Long userId,Long subjectId) {
        var user = (User) em.createQuery(
                "SELECT u FROM User u WHERE u.id = :id")
                .setParameter("id", userId)
                .getSingleResult();
        var subject = (Subject) em.createQuery(
                "SELECT s FROM Subject s WHERE s.id = :id")
                .setParameter("id", subjectId)
                .getSingleResult();
        var course = new Course(subject);
        user.createCourse(course);
        return Optional.of(repo.save(course));
    }

    @Override
    @Transactional
    public Optional<Course> teacherSearchOwnCourse(Long userId,Long subjectId) {
        var course = (Course) em.createQuery(
                "SELECT c FROM Course c WHERE c.subject.id = :id " +
                        "AND c.createdUser.id = :idUser")
                .setParameter("id", subjectId)
                .setParameter("idUser", userId)
                .getSingleResult();
        return ofNullable(course);
    }

    @Override
    public Optional<Course> retrievedCourse(String id) {
        return repo.findById(id);
    }

    @Override
    public Optional<List<Course>> retrieveBySearch(String search) {
        return repo.searchCourse(search);
    }

    @Override
    @Transactional
    public Optional<List<Course>> retrieveAllCourseByCreatedUser(Long userId) {
        var user = em.createQuery(
                "SELECT u FROM User u WHERE u.id = :id")
                .setParameter("id", userId)
                .getSingleResult();
        return repo.findCourseByCreatedUser((User) user);
    }

    @Override
    public Optional<List<Course>> retrieveAllCourseEnrolled(Long userId) {
        return Optional
                .ofNullable((List<Course>) em.createQuery(
                        "SELECT c FROM Course c " +
                                "INNER JOIN c.enrolledUser u " +
                                "WHERE u.id = :id")
                        .setParameter("id", userId)
                        .getResultList());
    }

    @Override
    public Optional<List<Course>> retrieveAllCourseBySubject(Long idSub) {
        var subject = (Subject) em.createQuery(
                "SELECT s FROM Subject s WHERE s.id = :param")
                .setParameter("param", idSub).getSingleResult();
        return repo.findCourseBySubject(subject);
    }

    @Override
    public void deleteCourse(String courseId) {
        repo.deleteById(courseId);
    }


}
