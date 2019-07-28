package com.github.bjlhx15.mybatis.readwrite.split.repository.read;

import com.github.bjlhx15.mybatis.readwrite.split.model.auto.AccountBalance;
import com.github.bjlhx15.mybatis.readwrite.split.model.auto.AccountBalanceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountBalanceReadMapper {

    AccountBalance selectByPrimaryKey(int id);


}