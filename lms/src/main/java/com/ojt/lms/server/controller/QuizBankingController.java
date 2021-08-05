package com.ojt.lms.server.controller;

import com.ojt.lms.server.model.dao.QuestionDetail;
import com.ojt.lms.server.service.QuizBankingHandler;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
@RestController
@Api(tags = "QuizBanking")
@RequestMapping("/api/quizbaking")
public class QuizBankingController {
    @NonNull
    QuizBankingHandler service;

    @GetMapping("/quiz/{id}")
    ResponseEntity<List<QuestionDetail>> getQuestionByQuiz(@PathVariable("id") Integer id) {
        try {
            return ResponseEntity.ok(service.getListQuestionFromQuiz(id)
                    .stream().findFirst()
                    .orElseThrow(IllegalArgumentException::new));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/ans-quiz/{id}")
    ResponseEntity<Map<Integer, String>> getAnsQuiz(@PathVariable("id") Integer id) {
        try {
            return ResponseEntity.ok(service.getAnsQuestionByQuiz(id)
                    .stream().findFirst()
                    .orElseThrow(IllegalArgumentException::new));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @GetMapping("/quizbanking/{id}")
    ResponseEntity<List<QuestionDetail>> getAnsQuizBanking(@PathVariable("id") Integer id) {
        try {
            return ResponseEntity.ok(service.getListQuestionFromQuizBanking(id)
                    .stream().findFirst()
                    .orElseThrow(IllegalArgumentException::new));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
