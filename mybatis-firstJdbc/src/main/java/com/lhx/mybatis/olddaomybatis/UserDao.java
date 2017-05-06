package com.lhx.mybatis.olddaomybatis;

import com.lhx.mybatis.po.User;

public interface UserDao {
	// 一般会把异常抛出
	public User getUserById(int id) throws Exception;

	public void insertUser(User user) throws Exception;
}
