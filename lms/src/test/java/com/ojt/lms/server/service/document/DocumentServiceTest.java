package com.ojt.lms.server.service.document;

import com.ojt.lms.server.model.dto.Document;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DocumentServiceTest {
    @Autowired
    DocumentService service;

    List<Document> documents = Arrays.asList(
            new Document(LocalDate.parse("2021-06-08"), "This is test Document".getBytes(StandardCharsets.UTF_8)),
            new Document(LocalDate.parse("2021-06-08"), "Fuck up, I'll end it by myself".getBytes(StandardCharsets.UTF_8))
    );

    @Test
    void getDocumentFromTopic() {
        service.getDocumentFromTopic(8L)
            .stream().findAny()
            .stream().forEach(System.out::println);
    }

    @Test
    void createOrUpdateDocument() {
        documents.forEach(d -> service.createOrUpdateDocument(8L, d));
    }

    @Test
    void retrieveById() {
        service.retrieveById(1);
    }

    @Test
    void deleteDocument() {
    }
}