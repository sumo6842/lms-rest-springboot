package com.ojt.lms.server.service.subject_impl;

import com.ojt.lms.server.model.dto.Video;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VideoServiceTest {
    @Autowired
    VideoService service;
    List<Video> videos = Arrays.asList(
            new Video("Kick Start","https://www.youtube.com/watch?v=-FmWuCgJmxo"),
            new Video("Advance","https://www.youtube.com/watch?v=cvTxHx6MhpM"),
            new Video("Kick Start","https://www.youtube.com/watch?v=TUASlasSPkE")
    );

    @Test
    void createVideo() {
        videos.forEach(v -> service.addOrUpdate("COURSE_152", v));
    }

    @Test
    void getAllCourse() {
        service.getVideo("COURSE_102")
                .stream().forEach(System.out::println);
    }
}