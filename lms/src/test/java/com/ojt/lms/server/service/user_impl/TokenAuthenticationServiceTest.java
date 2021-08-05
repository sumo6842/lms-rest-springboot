package com.ojt.lms.server.service.user_impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class TokenAuthenticationServiceTest {
    @Autowired
    TokenAuthenticationService service;
    @Autowired
    PasswordEncoder passwordEncoder;


    @Test
    public void test() {
        var param = "eyJhbGciOiJIUzI1NiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAAAKtWyiwuVrJSyk8uyS9ILUpT0lHKTCxRsjI0MzI3tjCzNDXQUUqtKIAImJgbG4MESotTi_ISc1OB-rISyxId0nMTM3P0kvNzlWoBO7i5LFAAAAA.EA0Pk0ittV4HIioiq-RgyibJWp3pUlKssIoMXb8kZx8";
        var userByToken = service.findUserByToken(param);
//        var userDetail = new UserDetail(userByToken.get().getEmail(), userByToken.get().getPassword());
//        System.out.println(userDetail.getUsername());
    }


}