package org.example.demo.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.example.demo.common.Account;
import org.example.demo.common.req.SignReq;
import org.example.demo.service.AccountService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;


@Api("账户接口")
@Slf4j
@RestController
public class AccountController {
    @Resource
    private AccountService accountService;


    @GetMapping("/sign")
    public Account sign(@Valid SignReq req) {
        Account account = accountService.sign(req);
        return account;
    }

    @PostMapping("/login")
    public Boolean login(String username, String password) {
        try {
            if (!StringUtils.hasLength(username) || !StringUtils.hasLength(password)){
                return false;
            }
            log.info("username: {}, password: {}", username, password);
            Boolean result = accountService.login(username, password);
            return result;
        } catch (Exception e) {
            log.error("login error", e);
            return false;
        }
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
