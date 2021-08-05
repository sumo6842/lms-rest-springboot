package com.ojt.lms.server.service.document;

import com.ojt.lms.server.model.dto.Assignment;
import com.ojt.lms.server.model.dto.Topic;
import com.ojt.lms.server.repo.AssignmentRepository;
import com.ojt.lms.server.service.AssignmentHandler;
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
public class AssignmentService implements AssignmentHandler {
    @NonNull
    AssignmentRepository repo;
    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public Optional<List<Assignment>> getAssignmentFromTopic(Long idTopic) {
        Topic topic = (Topic)em.createQuery("SELECT t FROM Topic t WHERE t.topicID = :id")
                .setParameter("id", idTopic)
                .getSingleResult();
        return repo.findAssignmentByTopic(topic);
    }

    @Override
    @Transactional
    public Optional<Assignment> createOrUpdateAssignment(Long idTopic, Assignment Assignment) {
        Topic topic = (Topic)em.createQuery("SELECT t FROM Topic t WHERE t.topicID = :id")
                .setParameter("id", idTopic)
                .getSingleResult();
        topic.getAssignments().add(Assignment);
        Assignment.setTopic(topic);
        return Optional.of(repo.save(Assignment));
    }

    @Override
    public Optional<Assignment> retrieveById(Integer assId) {
        return repo.findById(assId);
    }

    @Override
    public void deleteAssignment(Integer id) {
        repo.deleteById(id);
    }
}
