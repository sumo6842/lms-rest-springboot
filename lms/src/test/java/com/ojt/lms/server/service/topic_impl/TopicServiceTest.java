package com.ojt.lms.server.service.topic_impl;

import com.ojt.lms.server.model.dto.Topic;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TopicServiceTest {
    @Autowired
    TopicService service;

    private List<Topic> topic = Arrays.asList(
            new Topic("Understanding Object Orientation"),
            new Topic("Putting it Together"),
            new Topic("What is HTML and CSS?"),
            new Topic("About JavaScript"),
            new Topic("Putting it Together")
    );
    /**
     * ("The Very Basic of Java', COURSE_001
     * 
     * COURSE_001
     * COURSE_102
     * COURSE_152
     * COURSE_202
     * COURSE_252
     * 
     * 

     */

    @Test
    void createTopic() {
        topic.stream()
                .forEach(u -> service.addTopic("COURSE_001", u));
    }

    @Test
    void getTopic() {
        service.getTopicFromCourse("COURSE_001")
        .stream().forEach(System.out::println);
    }
}