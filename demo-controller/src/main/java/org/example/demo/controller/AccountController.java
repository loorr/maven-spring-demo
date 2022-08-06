package org.example.demo.controller;

import org.example.demo.common.Account;
import org.example.demo.service.AccountService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class AccountController {
    @Resource
    private AccountService accountService;

    @GetMapping("/sign")
    public Account sign(String username, String password, String email) {
        if (!StringUtils.hasLength(username) || !StringUtils.hasLength(password)){
            return null;
        }
        Account account = accountService.sign(username, password, email);

        return account;
    }

    @PostMapping("/login")
    public Boolean login(String username, String password) {
        if (!StringUtils.hasLength(username) || !StringUtils.hasLength(password)){
            return false;
        }
        Boolean result = accountService.login(username, password);
        return result;
    }

    @PostMapping("/update-password")
    public Boolean updatePassword(String email) {
        if (!StringUtils.hasLength(email)){
            return false;
        }
        Boolean result = accountService.updatePassword(email);
        return null;
    }

    @PostMapping("/check-email-code")
    public Boolean checkEmailCode(String code) {
        if (!StringUtils.hasLength(code) || code.length() != 6){
            return false;
        }
        Boolean result = accountService.checkEmailCode(code);
        return result;
    }
}
