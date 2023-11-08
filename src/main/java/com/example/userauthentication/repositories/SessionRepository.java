package com.example.userauthentication.repositories;

import com.example.userauthentication.model.Session;
import com.example.userauthentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    Session findByUser(User user);
}
