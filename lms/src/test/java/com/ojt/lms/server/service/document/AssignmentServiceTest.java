package com.ojt.lms.server.service.document;

import com.ojt.lms.server.model.dto.Assignment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AssignmentServiceTest {
    @Autowired
    AssignmentService service;
    List<Assignment> assignmentList = Arrays.asList(
            new Assignment("Assignment 1", "This is assignment".getBytes(StandardCharsets.UTF_8)),
            new Assignment("Assignment 1", "This is assignment, again".getBytes(StandardCharsets.UTF_8))
    );

    @Test
    void getAssignmentFromTopic() {
        service.getAssignmentFromTopic(10L)
            .stream().forEach(System.out::println);
    }

    @Test
    void createOrUpdateAssignment() {
        assignmentList.stream()
                .forEach(a -> service.createOrUpdateAssignment(10L, a));
    }

    @Test
    void retrieveById() {
        var assignment = service.retrieveById(1);
        System.out.println(assignment);
    }

    @Test
    void deleteAssignment() {
    }
}