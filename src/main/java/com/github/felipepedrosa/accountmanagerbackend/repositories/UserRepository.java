package com.github.felipepedrosa.accountmanagerbackend.repositories;

import com.github.felipepedrosa.accountmanagerbackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
