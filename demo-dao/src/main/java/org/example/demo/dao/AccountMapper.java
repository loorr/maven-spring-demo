package org.example.demo.dao;

import org.apache.ibatis.annotations.*;
import org.example.demo.common.Account;

import java.util.List;

@Mapper
public interface AccountMapper {

    @Insert("insert into user_account(uid, nickname, password, email) " +
            "values(#{uid}, #{nickname}, #{password}, #{email})")
    int insertAccount(Account account);

    @Select("select * from user_account where nickname = #{userName} ")
    Account selectAccountByUserName(String userName);

    @Delete("delete from user_account where nickname = #{userName}")
    int deleteAccount(String userName);

    @Update("update user_account set password = #{password}, nickname=#{nickname}, email=#{email} " +
            "where uid=#{uid}")
    int updateAccount( Account account);

    @Insert("<script>" +
            "insert into user_account(uid, nickname, password, email) values " +
                "<foreach collection='a' separator=',' item='item'>" +
                "(#{item.uid}, #{item.nickname}, #{item.password}, #{item.email})" +
                "</foreach>" +
            "</script>")
    int batchInsertAccount(List<Account> accounts);

    @Update("<script>" +
            "update user_account " +
            "<set>" +
                "<if test='email!=null and email !=\"\"'>and email = #{email} </if>" +
                "<if test='password!=null and password !=\"\"'>and password = #{password} </if>" +
                "<if test='nickname!=null and nickname !=\"\"'>and nickname = #{nickname} </if>" +
            "</set>" +
            "where uid = #{userId}" +
            "</script>")
    int updateAccountByCondition(Account account, @Param("userId") Long uid);

    @Select("<script>" +
            "select * from user_account " +
            "<where>" +
                "<if test='email!=null and email !=\"\"'>and email = #{email} </if>" +
                "<if test='password!=null and password !=\"\"'>and password = #{password} </if>" +
                "<if test='nickname!=null and nickname !=\"\"'>and nickname = #{nickname} </if>" +
                "<if test='uid!=null'>and uid = #{uid} </if>" +
            "</where>" +
            "</script>")
    List<Account>  getAccounts(Account account);

}
