package com.ojt.lms.server.repo;

import com.ojt.lms.server.model.dto.Question;
import com.ojt.lms.server.model.dto.Quiz;
import com.ojt.lms.server.model.dto.QuizBanking;
import com.ojt.lms.server.model.dto.Subject;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends CrudRepository<Question, Integer> {
    Optional<List<Question>> findQuestionByQuizBanking(QuizBanking quizBanking);
    Optional<List<Question>> findQuestionBySubject(Subject subject);
}
