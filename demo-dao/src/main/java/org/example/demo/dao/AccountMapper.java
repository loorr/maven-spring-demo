package org.example.demo.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.example.demo.common.Account;

@Mapper
public interface AccountMapper {

    @Insert("insert into user_account(uid, nickname, password, email) " +
            "values(#{uid}, #{nickname}, #{password}, #{email})")
    int insertAccount(Account account);

}
