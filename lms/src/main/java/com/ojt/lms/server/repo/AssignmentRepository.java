package com.ojt.lms.server.repo;

import com.ojt.lms.server.model.dto.Assignment;
import com.ojt.lms.server.model.dto.Topic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AssignmentRepository extends CrudRepository<Assignment, Integer> {
    Optional<List<Assignment>> findAssignmentByTopic(Topic topic);
}
