package org.example.demo.service;

import com.fasterxml.jackson.databind.util.BeanUtil;
import org.example.demo.common.Account;
import org.example.demo.common.req.SignReq;
import org.example.demo.dao.AccountMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

@Service
public class AccountService {

    @Resource
    private AccountMapper accountMapper;

    public Account sign(SignReq req) {
        Account account = new Account();
        account.setUid(getUid());
        BeanUtils.copyProperties(req, account);
        int rows = accountMapper.insertAccount(account);
        return rows> 0 ? account : null;
    }

    private Long getUid(){
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            int num = random.nextInt(10);
            while (i == 0 && num == 0){
                num = random.nextInt(10);
            }
            stringBuffer.append(num);
        }
        return Long.valueOf(stringBuffer.toString());
    }

    public Boolean login(String username, String password) {
        Account account = accountMapper.selectAccountByUserName(username);
        if (account.getPassword().equals(password)){
            return true;
        }
        return false;
    }


    public Boolean updatePassword(String email) {
        // TODO 调用发送发送邮件的功能
        return null;
    }


    public Boolean checkEmailCode(String code) {
        return null;
    }

    public Boolean batchInsertAccount(List<Account> accountList) {
        for (int i = 0; i < accountList.size(); i++) {
            accountMapper.insertAccount(accountList.get(i));
        }
        return true;
    }

}
