package com.ojt.lms.server.model.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ojt.lms.server.model.dto.Course;
import com.ojt.lms.server.model.dto.Subject;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class SubjectDetail {
    Subject subject;

    @JsonProperty("id")
    Long getProperty() {
        return subject.getId();
    }

    @JsonProperty("name")
    String getName() {
        return subject.getName();
    }
    @JsonProperty("description")
    String getDescription() {
        return subject.getDescription();
    }

    @JsonProperty("courses")
    public List<CourseDetail> course() {
        return subject.getCourses()
                .stream()
                .map(CourseDetail::new)
                .collect(toList());
    }

}
