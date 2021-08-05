package com.ojt.lms.server.service;

import com.ojt.lms.server.model.dto.Course;
import com.ojt.lms.server.model.dto.Subject;
import com.ojt.lms.server.model.dto.User;

import java.util.List;
import java.util.Optional;
//todo
public interface SubjectHandler {
    List<Subject> retrieveAllSubject();

    Optional<List<Subject>> searchSubjectByString(String search);

    Optional<Subject> createNewSubject(Subject subject);

    Optional<Subject> getSubById(Long id);

}
