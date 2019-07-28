package com.github.bjlhx15.mybatis.readwrite.split.service;

import com.github.bjlhx15.mybatis.readwrite.split.model.auto.AccountBalance;
import com.github.pagehelper.PageInfo;

public interface IAccountBalanceService {
    PageInfo getPageList(AccountBalance record);
    int insert(AccountBalance record);
}
