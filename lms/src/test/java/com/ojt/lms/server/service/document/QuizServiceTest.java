package com.ojt.lms.server.service.document;

import com.ojt.lms.server.model.dto.Quiz;
import lombok.NonNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class QuizServiceTest {
    @Autowired
    QuizService service;

    List<Quiz> quizList = Arrays.asList(
            new Quiz("Quiz 1", 160),
            new Quiz("Quiz 2", 180),
            new Quiz("Final Quiz", 60)
    );

    @Test
    void getQuizFromTopic() {
    }

    @Test
    void createOrUpdateQuiz() {
        quizList
                .forEach(q -> service.createOrUpdateQuiz(10L, q));

    }

    @Test
    void retrieveById() {
    }

    @Test
    void deleteQuiz() {
    }
}