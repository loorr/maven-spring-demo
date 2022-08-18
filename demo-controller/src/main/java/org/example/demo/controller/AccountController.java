package org.example.demo.controller;

import com.tove.web.infra.common.BaseErrorCode;
import com.tove.web.infra.common.Response;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.example.demo.api.AccountApi;
import org.example.demo.api.vo.AccountVo;
import org.example.demo.common.Account;
import org.example.demo.api.req.SignReq;
import org.example.demo.service.AccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;


@Api("账户接口")
@Slf4j
@RestController
public class AccountController implements AccountApi {
    @Resource
    private AccountService accountService;

    @Override
    public Response<AccountVo> sign(@RequestBody  @Valid SignReq req) {
        Account account = accountService.sign(req);
        AccountVo accountVo = new AccountVo();
        BeanUtils.copyProperties(account, accountVo);
        return Response.getOk(accountVo);
    }


    @Override
    public Response<Boolean> login(String username, String password) {
        try {
            if (!StringUtils.hasLength(username) || !StringUtils.hasLength(password)){
                return Response.getFail(BaseErrorCode.ILLEGAL_PARAMETERS);
            }
            log.info("username: {}, password: {}", username, password);
            Boolean result = accountService.login(username, password);
            return Response.getOk(result);
        } catch (Exception e) {
            log.error("login error", e);
            return Response.getFail();
        }
    }


    @Override
    public Boolean updatePassword(String email) {
        if (!StringUtils.hasLength(email)){
            return false;
        }
        Boolean result = accountService.updatePassword(email);
        return null;
    }

    @Override
    public Boolean checkEmailCode(String code) {
        if (!StringUtils.hasLength(code) || code.length() != 6){
            return false;
        }
        Boolean result = accountService.checkEmailCode(code);
        return result;
    }
}
