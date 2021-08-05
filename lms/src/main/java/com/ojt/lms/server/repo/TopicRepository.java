package com.ojt.lms.server.repo;

import com.ojt.lms.server.model.dto.Course;
import com.ojt.lms.server.model.dto.Topic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TopicRepository extends CrudRepository<Topic, Long> {
    Optional<List<Topic>> findAllByCourse(Course course);
}
