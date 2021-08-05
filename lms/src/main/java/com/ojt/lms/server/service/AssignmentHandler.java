package com.ojt.lms.server.service;

import com.ojt.lms.server.model.dto.Assignment;

import java.util.List;
import java.util.Optional;

//CRUD
public interface AssignmentHandler {
    Optional<List<Assignment>> getAssignmentFromTopic(Long idTopic);

    Optional<Assignment> createOrUpdateAssignment(Long idTopic, Assignment Assignment);
    Optional<Assignment> retrieveById(Integer assignmentId);

    void deleteAssignment(Integer id);

}
