package com.github.felipepedrosa.accountmanagerbackend.resources;

import com.github.felipepedrosa.accountmanagerbackend.models.Account;
import com.github.felipepedrosa.accountmanagerbackend.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountResource {

    @Autowired
    private AccountService service;

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Account create(@RequestBody Account account) {
        return service.create(account);
    }
}
