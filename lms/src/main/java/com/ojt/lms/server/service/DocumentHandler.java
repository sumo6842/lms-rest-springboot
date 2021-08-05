package com.ojt.lms.server.service;

import com.ojt.lms.server.model.dto.Document;
import com.ojt.lms.server.model.dto.Topic;

import java.util.List;
import java.util.Optional;
//CRUD
public interface DocumentHandler {
    Optional<List<Document>> getDocumentFromTopic(Long idTopic);

    Optional<Document> createOrUpdateDocument(Long idTopic, Document document);
    Optional<Document> retrieveById(Integer idDoc);

    void deleteDocument(Integer id);



}
