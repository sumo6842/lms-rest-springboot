package com.ojt.lms.server.service.topic_impl;


import com.ojt.lms.server.model.dto.Course;
import com.ojt.lms.server.model.dto.Topic;
import com.ojt.lms.server.repo.TopicHandler;
import com.ojt.lms.server.repo.TopicRepository;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@Service
@FieldDefaults(level = PRIVATE, makeFinal = true )
@AllArgsConstructor
public class TopicService implements TopicHandler {
    @NonNull
    TopicRepository repo;

    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public Optional<List<Topic>> getTopicFromCourse(String idCourse) {
        var course = em.createQuery("SELECT c FROM Course c WHERE c.courseID = :id")
                .setParameter("id", idCourse)
                .getSingleResult();
        return repo.findAllByCourse((Course)course);
    }

    @Override
    @Transactional
    public Optional<Topic> addTopic(String course, Topic topic) {
        var _course = (Course)em.createQuery("SELECT c FROM Course c WHERE c.courseID = :id")
                .setParameter("id", course)
                .getSingleResult();
        _course.getTopics().add(topic);
        topic.setCourse(_course);
        return Optional.of(repo.save(topic));
    }

    @Override
    public void deleteTopic(Long topicId) {
        repo.deleteById(topicId);
    }
}
