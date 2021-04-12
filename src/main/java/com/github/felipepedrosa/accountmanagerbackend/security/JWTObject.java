package com.github.felipepedrosa.accountmanagerbackend.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class JWTObject {
    private String subject;
    private Date issuedAt;
    private Date expiration;
}
