package com.ojt.lms.server.repo;

import com.ojt.lms.server.model.dto.Role;
import com.ojt.lms.server.model.dto.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class UserRepositoryTest {
    private final UserRepository repo;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;

    @Autowired
    UserRepositoryTest(UserRepository repo, RoleRepository roleRepository, PasswordEncoder encoder) {
        this.repo = repo;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }

    /**
     * INSERT INTO moodle.user (Email, RoleID, Password, First_Name, Last_Name, Phone, Address, Gender, DateOfBirth, Status)
     * VALUES ("otis@gmail.com", "TEC", "OtisTeacher", "Otis", "Phan", "0946746543", "Hồ Chí Minh", "Male", "2000-07-23", true);
     */
    @Test 
    void createUserTest() {
        var user = new User("otis@gmail.com", "OtisTeacher", "Otis", "Phan",
                "Hồ Chí Minh", "0946746543", false, LocalDate.parse("2000-07-23"), true);
        repo.save(user);
    }

    @Test
    public void getUser() {
        repo.findAll().forEach(System.out::println);
    }

    @Test
    void test() {
        Optional<Role> role = roleRepository.findById(1L);
        System.out.println(role);
        var userByEmail = repo.getUserByEmail("java@gmail.com");
        System.out.println(userByEmail);
    }

    @Test
    public void addRoleToUser() {
        var userByEmail = repo.getUserByEmail("java@gmail.com");

        roleRepository.findById(1L)
                .map(role -> userByEmail.getRole().add(role));
        System.out.println("User role: " + userByEmail.getRole());
    }
    @Test
    void testGetUserName() {
        var userByEmail = repo.getUserByEmail("ductran180699@gmail.com");
        assertThat(userByEmail).isNotNull();
        System.out.println(userByEmail.getId());
        var matches = encoder.matches(userByEmail.getPassword(), "Linhduc13");
        assertThat(matches).isTrue();

    }

    @Test
    void testWithSpecifiesObject() {
        var userByEmail = repo.getUserByEmail("java@gmail.com");
        var matches = encoder.matches(userByEmail.getPassword(), "123");
        assertThat(matches).isTrue();
    }

    @Test
    void testSearchString() {
        var user = repo.findUserByString("java").get();
        System.out.println(user);
        assertThat(user).isNotNull();
    }
}