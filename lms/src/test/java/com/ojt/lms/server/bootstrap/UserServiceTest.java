package com.ojt.lms.server.bootstrap;

import com.ojt.lms.server.model.dto.User;
import com.ojt.lms.server.repo.RoleRepository;
import com.ojt.lms.server.service.user_impl.UserService;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@SpringBootTest
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class UserServiceTest {
    UserService service;
    RoleRepository repo;
    @Autowired
    public UserServiceTest(UserService service, RoleRepository repo) {
        this.service = service;
        this.repo = repo;
    }

    List<User> users = Arrays.asList(
            new User("otis@gmail.com", "OtisTeacher", "Otis", "Phan",
                    "Ho Chi Minh", "0946746543", false, LocalDate.parse("2000-07-23"), true),
            new User("java@gmail.com", "123", "Joshua", "Block",
                    "Vũng Tàu", "0912254378", true, LocalDate.parse("1995-06-25"), true),
            new User("ductran180699@gmail.com", "Linhduc13",
                    "Duc", "Tran", "0345184306")
    );

    @Test
    void updateUserTest() {
//        var admin = repo.findById(1L).get();
//        var student = repo.findById(3L).get();
//        var user = new User("ductran180699@gmail.com", "Linhduc13",
//                "Duc", "Tran", "0345184306");
////        user.addRole(student);
//        service.updateUser(user, role);
//        var _admin = new User("java@gmail.com", "123", "Joshua", "Block",
//                "Vũng Tàu", "0912254378", true, LocalDate.parse("1995-06-25"), true);
////        _admin.addRole(admin);
//        service.updateUser(_admin, role);
    }

    @Test
    void deleteUser() {
//        service.deletedUser(5L);
//        service.deletedUser(9L);
    }
}
