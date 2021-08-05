package com.ojt.lms.server.service;

import com.ojt.lms.server.repo.UserRepository;
import com.ojt.lms.server.service.user_impl.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;

class MockUserServiceTest {
    @MockBean
    private UserRepository repo;

    @InjectMocks
    private UserService userService;

    @Test
    public void updateUserUserTest() {
//        var user = new User("test@gmail.com", "test",
//                "UserServiceTest", "John", "0345184306");
//        var updateUser = userService.updateUser(user, role);
//        System.out.println(updateUser);
//        assertThat(updateUser).isNotNull();
    }




}