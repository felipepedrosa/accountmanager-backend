package com.github.felipepedrosa.accountmanagerbackend.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -410495054394487439L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;
}
