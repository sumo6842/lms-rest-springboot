package com.ojt.lms.server.repo;

import com.ojt.lms.server.model.dto.Subject;
import com.ojt.lms.server.model.dto.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectRepository extends PagingAndSortingRepository<Subject, Long> {
    @Query("SELECT s FROM Subject AS s WHERE" +
            " CONCAT(s.name, ' ', s.description) LIKE %:search%")
    Optional<List<Subject>> findAll(String search);

}
