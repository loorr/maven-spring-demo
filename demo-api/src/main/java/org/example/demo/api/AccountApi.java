package org.example.demo.api;

import com.tove.web.infra.common.Response;
import io.swagger.annotations.Api;
import org.example.demo.api.req.SignReq;
import org.example.demo.api.vo.AccountVo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Api(value = "AccountApi", description = "账户相关接口")
public interface AccountApi {
    @PostMapping(value = "/sign", produces = MediaType.APPLICATION_JSON_VALUE)
    Response<AccountVo> sign(@RequestBody @Valid SignReq req);

    @PostMapping("/login")
    Response<Boolean> login(String username, String password);


    @PostMapping("/update-password")
    Boolean updatePassword(String email);


    @PostMapping("/check-email-code")
    Boolean checkEmailCode(String code);
}
