package com.ojt.lms.server.service.document;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ojt.lms.server.model.dao.QuestionDetail;
import com.ojt.lms.server.model.dto.Question;
import com.ojt.lms.server.model.dto.Quiz;
import com.ojt.lms.server.model.dto.QuizBanking;
import com.ojt.lms.server.repo.QuizBankingRepository;
import com.ojt.lms.server.service.QuizBankingHandler;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;

@Service
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor
public class QuizBankingService implements QuizBankingHandler {
    @NonNull
    QuizBankingRepository repo;
    @PersistenceContext
    EntityManager em;

    @Transactional
    @Override
    public Optional<List<QuestionDetail>> getListQuestionFromQuizBanking(Integer idQB) {
        var list = (List<Question>) em.createQuery("SELECT c.questionOfQuiz FROM QuizBanking c WHERE c.quizBankingID = :id")
                .setParameter("id", idQB)
                .getResultList();

        return Optional.of(
                list.stream()
                        .map(QuestionDetail::new)
                        .collect(Collectors.toList()));
    }
    @Transactional
    @Override
    public Optional<List<QuestionDetail>> getListQuestionFromQuiz(Integer idQuiz) {
        var list = (List<Question>) em.createQuery("SELECT c.questionOfQuiz FROM QuizBanking c WHERE c.quiz.quizID = :id")
                .setParameter("id", idQuiz)
                .getResultList();

        return Optional.of(
                list.stream()
                        .map(QuestionDetail::new)
                        .collect(Collectors.toList()));
    }

    @Override
    public Optional<QuizBanking> createQuizBanking(Integer idQuiz, QuizBanking quizBanking) {
        return Optional.empty();
    }

    @Override
    public Optional<Quiz> generateQuiz(Integer Id) {
        return Optional.empty();
    }

    @Transactional
    @Override
    public Optional<Map<Integer, String>> getAnsQuestionByQuiz(Integer id) throws Exception {
        var list = (List<Question>) em.createQuery("SELECT c.questionOfQuiz FROM QuizBanking c WHERE c.quiz.quizID = :id")
                .setParameter("id", id)
                .getResultList();

        return Optional.of(getAnswerOfQuestion(list));
    }

    private Map<Integer, String> getAnswerOfQuestion(List<Question> questionOfQuiz) throws Exception {
        if (questionOfQuiz.isEmpty()) {
            throw new Exception("List question is null");
        }
        return questionOfQuiz.stream()
                .map(q -> q.getQuestionID()+ ":" + q.getCorrectAns())
                .map(q -> q.split(":"))
                .collect(Collectors.toMap(e -> Integer.parseInt(e[0]), e -> e[1]));
    }

}
