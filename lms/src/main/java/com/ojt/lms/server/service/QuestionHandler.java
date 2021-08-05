package com.ojt.lms.server.service;

import com.ojt.lms.server.model.dao.QuestionDetail;
import com.ojt.lms.server.model.dto.Question;
import com.ojt.lms.server.model.dto.Quiz;
import io.swagger.models.auth.In;

import java.util.List;
import java.util.Optional;

//CRUD
public interface QuestionHandler {
    Optional<List<Question>> getQuestionFromSubject(Long subId);

    Optional<Question> createOrUpdateQuestion(Long idSub, Integer idQB, Question question);
    Optional<Question> retrieveById(Integer idQ);
    Optional<List<QuestionDetail>> getQuestionToQuiz(Integer idQuiz);
    void deleteQuiz(Integer id);

}
