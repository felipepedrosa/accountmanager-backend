package com.github.felipepedrosa.accountmanagerbackend.services;

import com.github.felipepedrosa.accountmanagerbackend.config.security.SessionDTO;
import com.github.felipepedrosa.accountmanagerbackend.models.User;
import com.github.felipepedrosa.accountmanagerbackend.repositories.UserRepository;
import com.github.felipepedrosa.accountmanagerbackend.utils.JWTUtils;
import com.github.felipepedrosa.accountmanagerbackend.services.exceptions.AuthenticationException;
import com.github.felipepedrosa.accountmanagerbackend.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LoginService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    public SessionDTO login(User user) {
        User foundUser = repository.findByEmail(user.getEmail()).orElseThrow(ResourceNotFoundException::new);

        if (!encoder.matches(user.getPassword(), foundUser.getPassword())) {
            throw new AuthenticationException();
        }

        return new SessionDTO(foundUser.getEmail(), JWTUtils.createToken(foundUser.getEmail(),
                new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + JWTUtils.TOKEN_EXPIRATION)));
    }
}
