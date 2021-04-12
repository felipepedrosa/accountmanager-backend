package com.github.felipepedrosa.accountmanagerbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SessionDTO {
    private String login;
    private String token;
}
