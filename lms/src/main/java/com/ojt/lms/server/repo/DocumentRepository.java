package com.ojt.lms.server.repo;

import com.ojt.lms.server.model.dto.Document;
import com.ojt.lms.server.model.dto.Subject;
import com.ojt.lms.server.model.dto.Topic;
import com.ojt.lms.server.model.dto.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DocumentRepository extends CrudRepository<Document, Integer> {
    Optional<List<Document>> findDocumentByTopic(Topic topic);
}
