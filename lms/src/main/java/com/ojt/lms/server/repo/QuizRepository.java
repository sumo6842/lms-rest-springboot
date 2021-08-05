package com.ojt.lms.server.repo;

import com.ojt.lms.server.model.dto.Quiz;
import com.ojt.lms.server.model.dto.Topic;
import org.springframework.data.repository.CrudRepository;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.List;
import java.util.Optional;

public interface QuizRepository extends CrudRepository<Quiz, Integer> {
    Optional<List<Quiz>> findQuizByTopic(Topic topic);
}
