package com.grupo3.vilayara.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ListUserDTO {
    private long id;
    private String userName;
    private String creationDate;
}
