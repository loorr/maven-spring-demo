package org.example.demo.common.req;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class SignReq {

    @NotEmpty
    @Size(min = 3, max = 20)
    private String email;

    @NotEmpty
    @Size(min = 3, max = 20)
    private String password;

    @NotEmpty
    @Size(min = 3, max = 20)
    private String nickname;

    @NotNull
    @Min(0)
    @Max(100)
    private Integer age;
}
