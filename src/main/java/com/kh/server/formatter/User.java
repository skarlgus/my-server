package com.kh.server.formatter;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class User {

    private String userId;

    @DeCrypt
    @NotEmpty
    private String name;

    @DeCrypt
    private String email;


}
