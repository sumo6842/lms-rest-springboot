package com.ojt.lms.server.service;

import com.ojt.lms.server.model.dto.Quiz;

import java.util.List;
import java.util.Optional;

//CRUD
public interface QuizHandler {
    Optional<List<Quiz>> getQuizFromTopic(Long idTopic);

    Optional<Quiz> createOrUpdateQuiz(Long idTopic, Quiz Quiz);
    Optional<Quiz> retrieveById(Integer QuizId);

    void deleteQuiz(Integer id);

}
