package com.ojt.lms.server.repo;

import com.ojt.lms.server.model.dto.Subject;
import com.ojt.lms.server.model.dto.User;
import com.ojt.lms.server.service.SubjectHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SubjectRepositoryTest {
    SubjectRepository repo;
    UserRepository userRepo;

    @Autowired
    public SubjectRepositoryTest(SubjectRepository repo, UserRepository userRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
    }

    @Test
    void findListSubject() {
        var java = repo.findAll("java");
        java.stream().forEach(System.out::println);
    }
}