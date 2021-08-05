package com.ojt.lms.server.service.document;

import com.ojt.lms.server.model.dto.Quiz;
import com.ojt.lms.server.model.dto.Topic;
import com.ojt.lms.server.repo.QuizRepository;
import com.ojt.lms.server.service.QuizHandler;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@Service
@FieldDefaults(level = PRIVATE, makeFinal = true )
@AllArgsConstructor
public class QuizService implements QuizHandler {
    @NonNull
    QuizRepository repo;
    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public Optional<List<Quiz>> getQuizFromTopic(Long idTopic) {
        Topic topic = (Topic)em.createQuery("SELECT t FROM Topic t WHERE t.topicID = :id")
                .setParameter("id", idTopic)
                .getSingleResult();
        return repo.findQuizByTopic(topic);
    }

    @Override
    @Transactional
    public Optional<Quiz> createOrUpdateQuiz(Long idTopic, Quiz quiz) {
        Topic topic = (Topic)em.createQuery("SELECT t FROM Topic t WHERE t.topicID = :id")
                .setParameter("id", idTopic)
                .getSingleResult();
        topic.getQuizzes().add(quiz);
        quiz.setTopic(topic);
        return Optional.of(repo.save(quiz));
    }

    @Override
    public Optional<Quiz> retrieveById(Integer assId) {
        return repo.findById(assId);
    }

    @Override
    public void deleteQuiz(Integer id) {
        repo.deleteById(id);
    }


}
