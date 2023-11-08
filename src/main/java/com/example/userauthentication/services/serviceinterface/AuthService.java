package com.example.userauthentication.services.serviceinterface;

import com.example.userauthentication.model.User;

import java.util.Optional;

public interface AuthService {
    Optional<String> login(User user);

    Optional<Boolean> validate(User user);
}
