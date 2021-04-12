package com.github.felipepedrosa.accountmanagerbackend.services.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardError implements Serializable {
    private static final long serialVersionUID = -428913076258541525L;
    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
