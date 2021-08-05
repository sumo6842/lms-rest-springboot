package com.ojt.lms.server.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;


@Data
@Entity
@NoArgsConstructor
@Table(name = "subject")
@FieldDefaults(level = PRIVATE)
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "description")
    String description;

    @OneToMany(mappedBy = "subject")
    List<Course> courses;

    @OneToMany(mappedBy = "subject")
    private List<Question> questions;

    public Subject(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("%4d|%5s|%15s", id, name, description);
    }
}
