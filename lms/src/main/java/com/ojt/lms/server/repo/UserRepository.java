package com.ojt.lms.server.repo;

import com.ojt.lms.server.model.dto.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends PagingAndSortingRepository<User, Long>{
    @Query("SELECT u FROM User AS u WHERE u.email = :email")
    User getUserByEmail(String email);

    @Query("SELECT u FROM User AS u WHERE" +
            " CONCAT(u.email,' ',u.firstName,' ',u.lastName) LIKE %:search%")
    Optional<List<User>> findUserByString(String search);

    @Query("UPDATE User u SET u.enable = ?2 WHERE u.id = ?1 ")
    @Modifying
    void updateEnabledStatus(Long id, boolean enabled);
}
