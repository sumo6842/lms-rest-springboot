package com.ojt.lms.server.repo;

import com.ojt.lms.server.model.dto.Topic;

import java.util.List;
import java.util.Optional;

public interface TopicHandler {


    Optional<List<Topic>> getTopicFromCourse(String idCourse);

    Optional<Topic> addTopic(String course, Topic topic);

    void deleteTopic(Long topicId);

}
