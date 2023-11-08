package com.example.userauthentication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Session extends BaseModel{
    @ManyToOne
    private User user;
    private String token;
}
