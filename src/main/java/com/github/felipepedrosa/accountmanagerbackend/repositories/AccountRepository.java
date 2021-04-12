package com.github.felipepedrosa.accountmanagerbackend.repositories;

import com.github.felipepedrosa.accountmanagerbackend.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
