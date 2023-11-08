package com.example.userauthentication.services;

import com.example.userauthentication.model.Session;

import com.example.userauthentication.model.User;
import com.example.userauthentication.repositories.SessionRepository;
import com.example.userauthentication.services.serviceinterface.AuthService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    private final SessionRepository sessionRepository;

    public AuthServiceImpl(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Override
    public Optional<String> login(User user) {
        // generate a random string generated from the email, password and full name of the user

        if (user == null){
            return Optional.empty();
        }

        String fullName = user.getFirstName() + user.getLastName();
        String email = user.getEmail();
        String password = user.getPassword();
        String token = email.substring(0, email.length()/2) + "#" +
                password.substring(0, password.length()/2) + "#" +
                fullName.substring(0, fullName.length()/2);

        Session session = new Session();
        session.setUser(user);
        session.setToken(token);

        sessionRepository.save(session);

        return Optional.of(token);
    }

    @Override
    public Optional<Boolean> validate(User user) {
        //check if the token is there in DB or not

        if (user == null){
            return Optional.empty();
        }

        Session session = sessionRepository.findByUser(user);

        if (session.getToken() == null || session.getToken().isEmpty()){
            return Optional.of(false);
        }
        return Optional.of(true);
    }
}
