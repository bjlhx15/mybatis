package com.github.bjlhx15.mybatis.readwrite.split.service.impl;

import com.github.bjlhx15.mybatis.readwrite.split.model.auto.AccountBalance;
import com.github.bjlhx15.mybatis.readwrite.split.repository.read.AccountBalanceReadMapper;
import com.github.bjlhx15.mybatis.readwrite.split.repository.write.AccountBalanceWriteMapper;
import com.github.bjlhx15.mybatis.readwrite.split.service.IAccountBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountBalanceServiceImpl implements IAccountBalanceService {
    @Autowired
    AccountBalanceWriteMapper writeMapper;
    @Autowired
    AccountBalanceReadMapper readMapper;

    @Override
    public AccountBalance selectByPrimaryKey(int id) {
        return readMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(AccountBalance record) {
        return writeMapper.insert(record);
    }
}
