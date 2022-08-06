package org.example.demo.common;

import lombok.*;

@Data
public class Account {
    private Long id;
    private Long uid;
    private String nickname;
    private String password;
    private String email;
}
