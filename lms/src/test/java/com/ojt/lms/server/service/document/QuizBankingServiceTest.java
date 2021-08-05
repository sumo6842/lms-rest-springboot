package com.ojt.lms.server.service.document;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QuizBankingServiceTest {
    @Autowired
    QuizBankingService service;
    @Test
    void getListQuestion() {
        service.getListQuestionFromQuizBanking(1)
                .ifPresent(System.out::println);
    }

    @Test
    void createQuizBanking() throws Exception {
        var quizBanking = service.getAnsQuestionByQuiz(1);
        quizBanking.stream().findAny()
                .orElseThrow()
                .entrySet()
                .stream()
                .map(s -> s.getKey() + ": " + s.getValue())
                .forEach(System.out::println);
    }

    @Test
    void generateQuestion() {
       service.getListQuestionFromQuiz(1)
               .stream().forEach(System.out::println);
    }
}