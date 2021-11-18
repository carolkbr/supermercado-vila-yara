package com.grupo3.vilayara.dtos;

import com.grupo3.vilayara.enums.UserType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserDTO {
    private String userName;
    private String name;
    private String email;
    private String password;
    private String creationDate;
    private UserType type;
}
