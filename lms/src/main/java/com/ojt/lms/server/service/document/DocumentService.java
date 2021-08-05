package com.ojt.lms.server.service.document;

import com.ojt.lms.server.model.dto.Document;
import com.ojt.lms.server.model.dto.Topic;
import com.ojt.lms.server.repo.DocumentRepository;
import com.ojt.lms.server.service.DocumentHandler;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@Service
@FieldDefaults(level = PRIVATE, makeFinal = true )
@AllArgsConstructor
public class DocumentService implements DocumentHandler {
    @NonNull
    DocumentRepository repo;
    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public Optional<List<Document>> getDocumentFromTopic(Long idTopic) {
        Topic topic = (Topic)em.createQuery("SELECT t FROM Topic t WHERE t.topicID = :id")
                .setParameter("id", idTopic)
                .getSingleResult();
        return repo.findDocumentByTopic(topic);
    }

    @Override
    @Transactional
    public Optional<Document> createOrUpdateDocument(Long idTopic, Document document) {
        Topic topic = (Topic)em.createQuery("SELECT t FROM Topic t WHERE t.topicID = :id")
                .setParameter("id", idTopic)
                .getSingleResult();
        topic.getDocuments().add(document);
        document.setTopic(topic);
        return Optional.of(repo.save(document));
    }

    @Override
    public Optional<Document> retrieveById(Integer idDoc) {
        return repo.findById(idDoc);
    }

    @Override
    public void deleteDocument(Integer id) {
        repo.deleteById(id);
    }
}
