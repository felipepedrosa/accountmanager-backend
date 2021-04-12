package com.github.felipepedrosa.accountmanagerbackend.resources;

import com.github.felipepedrosa.accountmanagerbackend.config.security.SessionDTO;
import com.github.felipepedrosa.accountmanagerbackend.dtos.UserWithoutPasswordDTO;
import com.github.felipepedrosa.accountmanagerbackend.models.User;
import com.github.felipepedrosa.accountmanagerbackend.services.LoginService;
import com.github.felipepedrosa.accountmanagerbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public UserWithoutPasswordDTO create(@RequestBody() User user) {
        return userService.create(user);
    }

    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<UserWithoutPasswordDTO> index() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public UserWithoutPasswordDTO show(@PathVariable long id) {
        return userService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        userService.delete(id);
    }

    @PostMapping("/login")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public SessionDTO login(@RequestBody User user) {
        return loginService.login(user);
    }
}
