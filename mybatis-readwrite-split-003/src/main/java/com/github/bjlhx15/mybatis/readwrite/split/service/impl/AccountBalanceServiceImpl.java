package com.github.bjlhx15.mybatis.readwrite.split.service.impl;

import com.github.bjlhx15.mybatis.readwrite.split.model.auto.AccountBalance;
import com.github.bjlhx15.mybatis.readwrite.split.model.auto.AccountBalanceExample;
import com.github.bjlhx15.mybatis.readwrite.split.repository.auto.AccountBalanceMapper;
import com.github.bjlhx15.mybatis.readwrite.split.service.IAccountBalanceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountBalanceServiceImpl implements IAccountBalanceService {
    @Autowired
    AccountBalanceMapper mapper;

    @Override
    public PageInfo getPageList(AccountBalance record) {
        AccountBalanceExample example = new AccountBalanceExample();
        AccountBalanceExample.Criteria criteria = example.createCriteria();
        if (record != null) {
            criteria.andNameEqualTo(record.getName());
        }
        PageHelper.startPage(1, 3);
        List<AccountBalance> accountBalances = mapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(accountBalances);
        return pageInfo;
    }

    @Override
    public int insert(AccountBalance record) {
        return mapper.insert(record);
    }
}
