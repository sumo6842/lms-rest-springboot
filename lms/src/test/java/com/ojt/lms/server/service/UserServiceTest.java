package com.ojt.lms.server.service;

import com.ojt.lms.server.model.dto.Course;
import com.ojt.lms.server.repo.CourseRepository;
import com.ojt.lms.server.repo.RoleRepository;
import com.ojt.lms.server.service.user_impl.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Rollback(value = false)
class UserServiceTest {

    private final UserService service;
    private final RoleRepository roleRepo;
    private final CourseRepository courseRepository;
    @Autowired
    UserServiceTest(UserService service,
                    RoleRepository roleRepo,
                    CourseRepository courseRepository) {
        this.service = service;
        this.roleRepo = roleRepo;
        this.courseRepository = courseRepository;
    }

    @Test
    public void createUser() {
//        var user = new User("otis@gmail.com", "OtisTeacher", "Ngô",
//                "Đức Lương", "Hồ Chí Minh", "0946746543", true,
//                LocalDate.parse("2000-07-23"), true);
//        var updateUser = service.updateUser(user);
//        var user_2 = new User("java@gmail.com", "123",
//                "Joshua", "Block","Vũng Tàu",
//                "0912254378", false, LocalDate.parse("1995-06-25"), true);
//        var _updateUser = service.updateUser(user_2);
//        assertThat(updateUser).isNotNull();
    }

    @Test
    void retrieveUserTest() {
        System.out.println("All user");
        service.retrievedAllUser().forEach(System.out::println);
    }

    @Test
    void retrieveUserBySearchStringTest() {
        System.out.println("Search: ");
        var duc = service.retrievedUser("duc");
        System.out.println(duc);
    }

    @Test
    void updateUserCreateTest() {
//        var user = new User("test@gmail.com", "test", "John", "Cena",
//                "Danang City", "0345184306", true,  LocalDate.parse("1999-06-09"),true);
//        var user1 = service.updateUser(user);
//        assertThat(user1).isNotNull();

    }

    @Test
    void updateUserTest() {
        var user = service.retrieveUserById(16L);
        assertThat(user).isNotNull();
        user.get().setPassword("123");
        service.updateUser(user.get());
    }

    @Test
    void deleteUserTest() {
        var user = service.retrievedUser("test");
//        roleRepo.findRoleByRoleName()
    }

    @Test
    void enroll() {
        var _course = courseRepository.findById("COURSE_001");
        var course = service.enrollCourse(4L,"COURSE_001");
    }

    @Test
    void unEnrolledTest() {
        service.unEnrolledCourse(4L, "COURSE_001");
    }

    @Test
    void getUserCourse() {
        service.getAllUserEnrolledCourse("COURSE_001")
                .stream().forEach(System.out::println);
    }
}