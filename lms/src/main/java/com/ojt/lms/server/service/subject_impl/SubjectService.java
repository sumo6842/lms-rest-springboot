package com.ojt.lms.server.service.subject_impl;

import com.ojt.lms.server.model.dto.Course;
import com.ojt.lms.server.model.dto.Subject;
import com.ojt.lms.server.model.dto.User;
import com.ojt.lms.server.repo.SubjectRepository;
import com.ojt.lms.server.service.SubjectHandler;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

/**
 * CR subject
 */
@Service
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor
public class SubjectService implements SubjectHandler {
    @NonNull
    SubjectRepository repo;

    @Override
    public List<Subject> retrieveAllSubject() {
        return (List<Subject>) repo.findAll();
    }

    @Override
    public Optional<List<Subject>> searchSubjectByString(String search) {
        return Optional.empty();
    }

    @Override
    public Optional<Subject> createNewSubject(Subject subject) {
        return Optional.of(repo.save(subject));
    }

    @Override
    public Optional<Subject> getSubById(Long id) {
        return repo.findById(id);
    }

}
