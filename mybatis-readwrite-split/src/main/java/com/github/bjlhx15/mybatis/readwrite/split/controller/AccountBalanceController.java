package com.github.bjlhx15.mybatis.readwrite.split.controller;

import com.github.bjlhx15.mybatis.readwrite.split.service.IAccountBalanceService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ab")
public class AccountBalanceController {

    Logger logger = LoggerFactory.getLogger(AccountBalanceController.class);
    @Autowired
    private IAccountBalanceService service;

    @RequestMapping("page")
    @ResponseBody
    public ResponseEntity getPageList(){
        logger.error("requestdata:");
        PageInfo pageList = service.getPageList(null);
        return ResponseEntity.ok(pageList);
    }
}
