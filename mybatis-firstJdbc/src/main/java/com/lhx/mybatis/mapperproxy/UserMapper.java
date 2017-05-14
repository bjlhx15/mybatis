package com.lhx.mybatis.mapperproxy;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lhx.mybatis.po.Order;
import com.lhx.mybatis.po.QueryVo;
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

	public List<User> findUserByHashmap(HashMap<String, Object> map) throws Exception;

	public List<User> findUserList(QueryVo queryVo) throws Exception;
	
	public List<User> findUserListResultMap(QueryVo queryVo) throws Exception;
	
	public List<User> selectUserByList(List<User> userlist) throws Exception;
	
	public List<User> selectUserByArrayPojo(Object[] userlist) throws Exception;
	
	public List<User> selectUserByArray(Object[] userlist) throws Exception;

	List<User> findMutli()throws Exception;
}