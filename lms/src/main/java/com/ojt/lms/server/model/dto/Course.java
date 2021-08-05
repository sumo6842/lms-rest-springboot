package com.ojt.lms.server.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ojt.lms.server.util.identity.StringPrefixedSequenceIdGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;
import static lombok.AccessLevel.PRIVATE;

@Data
@Entity
@Table(name = "course")
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Course {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_seq")
    @GenericGenerator(
            name = "course_seq",
            strategy = "com.ojt.lms.server.util.identity.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "COURSE_"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d")
            })
    String courseID;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    Subject subject; //Foreign key table subject

    @ManyToOne
    @JoinColumn(name = "user_id")
    User createdUser;

    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledCourse")
    List<User> enrolledUser = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "course", orphanRemoval = true)
    List<Topic> topics = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "course", orphanRemoval = true)
    List<Video> videos = new ArrayList<>();

    public Course(Subject subject) {
        this.subject = requireNonNull(subject);
    }

    @JsonProperty("id_subject")
    public Long getSubject() {
        return subject.getId();
    }

    @JsonProperty("id_course")
    public String getCourseID() {
        return courseID;
    }

    @JsonProperty("created_user")
    public String getCreatedUser() {
        return createdUser.getFirstName();
    }
    @JsonProperty("subject_user")
    public String getSubUser() {
        return courseID + "-" + createdUser.getFirstName();
    }

    @Override
    public String toString() {
        return String.format("%5s|%5s|%5s%n", courseID, subject.getName(),
                createdUser.getFirstName() + createdUser.getLastName());
    }
}
