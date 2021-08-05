package com.ojt.lms.server.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.checkerframework.checker.units.qual.A;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Data
@Entity
@NoArgsConstructor
@Table(name = "topic")
@FieldDefaults(level = PRIVATE)
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long topicID;
    String topicTitle;

    @ManyToOne
    @JoinColumn(name = "course_id")
    Course course;


    @OneToMany(mappedBy = "topic", orphanRemoval = true)
    List<Assignment> assignments = new ArrayList<>();

    @OneToMany(mappedBy = "topic", orphanRemoval = true)
    List<Document> documents = new ArrayList<>();

    @OneToMany(mappedBy = "topic", orphanRemoval = true)
    List<Quiz> quizzes = new ArrayList<>();

    public Topic(String topicTitle) {
        this.topicTitle = topicTitle;
//        cours
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topicID=" + topicID +
                ", topicTitle='" + topicTitle + '\'' +
                ", course=" + course.getCourseID() +
                '}';
    }
}
