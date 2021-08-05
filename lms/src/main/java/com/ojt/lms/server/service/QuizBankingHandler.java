package com.ojt.lms.server.service;

import com.ojt.lms.server.model.dao.QuestionDetail;
import com.ojt.lms.server.model.dto.Question;
import com.ojt.lms.server.model.dto.Quiz;
import com.ojt.lms.server.model.dto.QuizBanking;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface QuizBankingHandler {
    Optional<List<QuestionDetail>> getListQuestionFromQuizBanking(Integer idQuiz);
    Optional<List<QuestionDetail>> getListQuestionFromQuiz(Integer idQuiz);

    Optional<QuizBanking> createQuizBanking(Integer idQuiz, QuizBanking quizBanking);

    Optional<Quiz> generateQuiz(Integer Id);

    Optional<Map<Integer, String>> getAnsQuestionByQuiz(Integer id) throws Exception;


}
