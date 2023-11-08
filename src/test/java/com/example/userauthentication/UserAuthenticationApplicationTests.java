package com.example.userauthentication;

import com.example.userauthentication.model.Session;
import com.example.userauthentication.model.User;
import com.example.userauthentication.repositories.SessionRepository;
import com.example.userauthentication.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserAuthenticationApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void saveUser() {
        User user = new User();
        user.setFirstName("Nakul");
        user.setLastName("Sudhakar");
        user.setEmail("Nakulsudhakar035@gmail.com");
        user.setPassword("qwe123");
        userRepository.save(user);
    }

    @Test
    void getUser() {
        User user = userRepository.findByEmail("Nakulsudhakar035@gmail.com").get();
        System.out.println(user.getFirstName());
    }

    @Test
    void getToken(){
        User user = userRepository.findByEmail("Nakulsudhakar035@gmail.com").get();
        Session session = sessionRepository.findByUser(user);
        System.out.println(session.getToken());
    }
}
