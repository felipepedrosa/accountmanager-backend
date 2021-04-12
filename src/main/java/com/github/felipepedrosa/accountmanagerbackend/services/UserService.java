package com.github.felipepedrosa.accountmanagerbackend.services;

import com.github.felipepedrosa.accountmanagerbackend.dtos.UserWithoutPasswordDTO;
import com.github.felipepedrosa.accountmanagerbackend.models.User;
import com.github.felipepedrosa.accountmanagerbackend.repositories.UserRepository;
import com.github.felipepedrosa.accountmanagerbackend.services.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder encoder;

    public UserWithoutPasswordDTO create(User user) {
        user.setPassword(encoder.encode(user.getPassword()));

        return modelMapper.map(repository.save(user), UserWithoutPasswordDTO.class);
    }

    public List<UserWithoutPasswordDTO> findAll() {
        return repository.findAll().stream()
                .map(user -> modelMapper.map(user, UserWithoutPasswordDTO.class))
                .collect(Collectors.toList());
    }

    public UserWithoutPasswordDTO findById(long id) {
        return repository.findById(id).map(user -> modelMapper.map(user, UserWithoutPasswordDTO.class))
                .orElseThrow(ResourceNotFoundException::new);
    }

    public void delete(long id) {
        User user = repository.findById(id).orElseThrow(ResourceNotFoundException::new);

        if (user != null) {
            repository.delete(user);
        }
    }
}
