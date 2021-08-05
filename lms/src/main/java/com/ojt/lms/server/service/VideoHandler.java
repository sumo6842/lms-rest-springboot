package com.ojt.lms.server.service;

import com.ojt.lms.server.model.dto.Video;

import java.util.List;
import java.util.Optional;

public interface VideoHandler {
    Optional<List<Video>> getVideo(String courseId);

    Optional<Video> addOrUpdate(String IdCourse, Video video);

}
