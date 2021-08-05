package com.ojt.lms.server.model.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ojt.lms.server.model.dto.Course;
import com.ojt.lms.server.model.dto.Topic;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class CourseDetail {
    @NonNull
    Course course;

    @JsonProperty("id")
    String getId() {
        return course.getCourseID();
    }

    @JsonProperty("video")
    List<VideoDetail> getVideo() {
        return course.getVideos().stream()
                .map(VideoDetail::new)
        .collect(toList());
    }
    //Topic,

}
