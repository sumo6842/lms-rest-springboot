package com.ojt.lms.server.service.document;

import com.ojt.lms.server.model.dao.QuestionDetail;
import com.ojt.lms.server.model.dto.Question;
import com.ojt.lms.server.model.dto.QuizBanking;
import com.ojt.lms.server.repo.QuestionRepository;
import com.ojt.lms.server.repo.QuizBankingRepository;
import com.ojt.lms.server.repo.SubjectRepository;
import com.ojt.lms.server.service.QuestionHandler;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static lombok.AccessLevel.PRIVATE;

@Service
@AllArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class QuestionService implements QuestionHandler {
    @NonNull
    QuestionRepository repo;
    @PersistenceContext
    EntityManager em;
    @NonNull
    QuizBankingRepository qbRepo;
    @NonNull
    SubjectRepository subRepo;
    Integer NUMBER_QUESTION = 5;

    @Override
    @Transactional
    public Optional<List<Question>> getQuestionFromSubject(Long subId) {
        var byId = subRepo.findById(subId)
                .orElseThrow(IllegalArgumentException::new);

        return repo.findQuestionBySubject(byId);
    }

    @Override
    public Optional<Question> createOrUpdateQuestion(
            Long idSub, Integer idQB, Question question) {
        return Optional.empty();
    }

    @Transactional
    @Override
    public Optional<Question> retrieveById(Integer idQ) {

        return Optional.empty();
    }

    @Override
    public Optional<List<QuestionDetail>> getQuestionToQuiz(Integer idQuiz) {
        QuizBanking q = (QuizBanking) em.createQuery("SELECT q FROM QuizBanking q WHERE q.quiz.quizID = :id")
                .setParameter("id", idQuiz)
                .getSingleResult();
        List<Question> questions = em.createQuery("SELECT q FROM Question q")
                .setMaxResults(5)
                .getResultList();
        return Optional.of(questions.stream()
                .peek(q::setQuestionOfQuiz)
                .map(QuestionDetail::new)
                .collect(toList()));
    }

    @Override
    public void deleteQuiz(Integer id) {

    }
}
