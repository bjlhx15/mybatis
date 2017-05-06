package com.lhx.mybatis.mapperproxy;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lhx.mybatis.po.User;

/**
 * 用户管理mapper
 */
public interface UserMapper {
	// 根据用户id查询用户信息
	public User findUserById(int id) throws Exception;

	// 查询用户列表
	public List<User> findUserByUsername(String username) throws Exception;

	// 添加用户信息
	public void insertUser(User user) throws Exception;

	public User findUserByIdAndSex(int id, int sex) throws Exception;

	public User findUserByIdAndSex2(@Param("id") int id, @Param("sex") int sex) throws Exception;
}