package com.github.felipepedrosa.accountmanagerbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserWithoutPasswordDTO {
    private Long id;
    private String fullName;
    private String email;
}
