package com.pineapple.authserver.dto;

import lombok.Data;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

@Data
public class JwtDto {

    private String name;
    private String email;
}
