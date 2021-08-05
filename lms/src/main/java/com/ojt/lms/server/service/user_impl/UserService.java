package com.ojt.lms.server.service.user_impl;

import com.ojt.lms.server.model.dto.Course;
import com.ojt.lms.server.model.dto.User;
import com.ojt.lms.server.repo.CourseRepository;
import com.ojt.lms.server.repo.RoleRepository;
import com.ojt.lms.server.repo.UserRepository;
import com.ojt.lms.server.service.UserHandler;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.util.Objects.requireNonNull;
import static lombok.AccessLevel.PRIVATE;

@Service
@Transactional
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor
public class UserService implements UserHandler {
    @NonNull
    UserRepository repo;
    @NonNull
    PasswordEncoder crypto;
    @PersistenceContext
    EntityManager em;

    private void encodePassword(User user) {
        user.setPassword(this.crypto.encode(user.getPassword()));
    }

    @Override
    public List<User> retrievedAllUser() {
        return (List<User>) repo.findAll();
    }

    @Override
    public Optional<List<User>> retrievedUser(String search) {
        return repo.findUserByString(search);
    }

    @Override
    public Optional<User> retrieveUserById(Long id) {
        return this.repo.findById(id);
    }

    @Override
    public User updateUser(User user) {
        boolean isUpdating = Objects.isNull(user.getId());
        if (!isUpdating) {
            User updating = repo.findById(user.getId()).get();
            if (user.getPassword().isEmpty()) {
                user.setPassword(updating.getPassword());
            } else {
                encodePassword(user);
            }
        } else {
            encodePassword(user);
        }
        return this.repo.save(user);
    }

    @Override
    public void updateStatus(Long userId, boolean status) {
        repo.updateEnabledStatus(userId, status);
    }

    @Override
    public void deletedUser(Long id) {
        repo.deleteById(requireNonNull(id));
    }

    @Override
    public Optional<List<User>> getAllUserEnrolledCourse(String courseId) {
        var query = em.createQuery("SELECT c.enrolledUser FROM Course c WHERE c.courseID = :id")
                         .setParameter("id", courseId)
                         .getResultList();
        return Optional.ofNullable(query);
    }

    @Override
    @Transactional
    public Optional<Course> enrollCourse(Long idUser, String courseId) {
        var _course = (Course)em.createQuery("SELECT c FROM Course c WHERE c.courseID = :id")
                .setParameter("id", courseId)
                .getSingleResult();
        var user = repo.findById(idUser).get();
        user.enroll(_course);
        return Optional.of(_course);
    }

    @Override
    public void unEnrolledCourse(Long userId, String courseId) {
        var _course = (Course)em.createQuery("SELECT c FROM Course c WHERE c.courseID = :id")
                .setParameter("id", courseId)
                .getSingleResult();
        repo.findById(userId)
                .ifPresent(user -> user.unenroll(_course));
    }
}
