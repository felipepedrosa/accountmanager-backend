package com.github.felipepedrosa.accountmanagerbackend.services;

import com.github.felipepedrosa.accountmanagerbackend.models.Account;
import com.github.felipepedrosa.accountmanagerbackend.models.User;
import com.github.felipepedrosa.accountmanagerbackend.repositories.AccountRepository;
import com.github.felipepedrosa.accountmanagerbackend.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepository repository;

    @Autowired
    private UserService userService;

    public Account create(Account account){
        User user = JWTUtils.getUserFromRequest(userService);
        account.setUser(user);

        return repository.save(account);
    }

}
