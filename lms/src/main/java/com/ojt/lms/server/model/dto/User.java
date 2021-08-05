package com.ojt.lms.server.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.checkerframework.checker.units.qual.C;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static lombok.AccessLevel.PRIVATE;

@Data
@Entity
@NoArgsConstructor
@Table(name = "_user")
@FieldDefaults(level = PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(length = 128, nullable = false, unique = true)
    String email;

    @Column(nullable = false)
    String password;

    @Column(length = 64, nullable = false)
    String firstName;

    @Column(length = 64, nullable = false)
    String lastName;

    @Column(length = 128)
    String address;

    @Column(nullable = false)
    String phone;

    boolean gender;

    LocalDate dob;

    boolean enable;

    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    List<Role> role = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "createdUser")
    List<Course> createCourse;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "enrolled_course",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    List<Course> enrolledCourse;

    public User(String email, String password,
                String firstName, String lastName, String phone) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
    }

    public User(String email, String firstName, String lastName,
                String address, String phone, boolean gender) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.gender = gender;
    }

    public User(String email, String password, String firstName,
                String lastName, String address, String phone,
                boolean gender, LocalDate dob, boolean enable) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.gender = gender;
        this.dob = dob;
        this.enable = enable;
    }

    public User(Long id, String email) {
        this.id = id;
        this.email = email;
    }

//    public List<Course> getEnrolledCourse() {
//        if(Objects.isNull(this.enrolledCourse)) {
//
//        }
//    }


    public List<Course> getEnrolledCourse() {
        if (Objects.isNull(this.enrolledCourse)) {
            enrolledCourse = new ArrayList<>();
        }
        return enrolledCourse;
    }

    //todo Create Course:
    public void createCourse(Course course) {
        if (Objects.isNull(this.createCourse)) {
            createCourse = new ArrayList<>();
        }
        createCourse.add(course);
        course.setCreatedUser(this);
    }

    // todo Create and Delete course:
    public void enroll(Course course) {
        this.enrolledCourse.add(course);
        course.getEnrolledUser().add(this);
    }

    public void unenroll(Course course) {
        this.enrolledCourse.remove(course);
        course.getEnrolledUser().remove(this);
    }

    // todo set Role:
    public void addRole(Role role) {
        this.role.add(role);
        role.getUsers().add(this);
    }

    public void deleteRole(Role role) {
        this.role.remove(role);
        role.getUsers().remove(this);
    }

    @Override
    public String toString() {
        return String.format("%4d|%10s|%5s|%5s", id, email, firstName, lastName);
    }
}
