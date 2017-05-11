package com.lhx.mybatis.mapperproxy;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lhx.mybatis.po.QueryVo;
import com.lhx.mybatis.po.User;

import junit.framework.TestCase;

public class UserMapperTest extends TestCase {

	private SqlSessionFactory sqlSessionFactory;

	protected void setUp() throws Exception {
		// mybatis配置文件
		String resource = "SqlMapConfig-MapperProxy.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 使用SqlSessionFactoryBuilder创建sessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	public void testFindUserById() throws Exception {
		// 获取session
		SqlSession session = sqlSessionFactory.openSession();
		// 获取mapper接口的代理对象
		UserMapper userMapper = session.getMapper(UserMapper.class);
		// 调用代理对象方法
		User user = userMapper.findUserById(1);
		System.out.println(user);
		// 关闭session
		session.close();

	}

	public void testFindUserByUsername() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = userMapper.findUserByUsername("张");
		System.out.println(list.size());

	}

	public void testInsertUser() throws Exception {
		// 获取session
		SqlSession session = sqlSessionFactory.openSession();
		// 获取mapper接口的代理对象
		UserMapper userMapper = session.getMapper(UserMapper.class);
		// 要添加的数据
		User user = new User();
		user.setUsername("张三");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("北京市");
		// 通过mapper接口添加用户
		userMapper.insertUser(user);
		// 提交
		session.commit();
		// 关闭session
		session.close();
	}

	public void testFindUserByIdAndSex() throws Exception {
		// 获取session
		SqlSession session = sqlSessionFactory.openSession();
		// 获取mapper接口的代理对象
		UserMapper userMapper = session.getMapper(UserMapper.class);
		// 调用代理对象方法
		User user = userMapper.findUserByIdAndSex(1, 2);
		System.out.println(user);
		// 关闭session
		session.close();

	}

	public void testFindUserByIdAndSex2() throws Exception {
		// 获取session
		SqlSession session = sqlSessionFactory.openSession();
		// 获取mapper接口的代理对象
		UserMapper userMapper = session.getMapper(UserMapper.class);
		// 调用代理对象方法
		User user = userMapper.findUserByIdAndSex2(1, 2);
		System.out.println(user);
		// 关闭session
		session.close();

	}

	public void testFindUserByHashmap() throws Exception {
		// 获取session
		SqlSession session = sqlSessionFactory.openSession();
		// 获限mapper接口实例
		UserMapper userMapper = session.getMapper(UserMapper.class);
		// 构造查询条件Hashmap对象
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", 1);
		map.put("username", "管理员");

		// 传递Hashmap对象查询用户列表
		List<User> list = userMapper.findUserByHashmap(map);
		// 关闭session
		session.close();
	}

	public void testFindUserListResultMap() throws Exception {
		// 获取session
		SqlSession session = sqlSessionFactory.openSession();
		// 获限mapper接口实例
		UserMapper userMapper = session.getMapper(UserMapper.class);
		QueryVo queryVo = new QueryVo();
		User user = new User();
		user.setUsername("张");
		user.setSex("女");
		queryVo.setUser(user);
		// 传递Hashmap对象查询用户列表
		List<User> list = userMapper.findUserListResultMap(queryVo);
		// 关闭session
		session.close();
	}

	public void testFindByQueryVo() throws Exception {
		// 获取session
		SqlSession session = sqlSessionFactory.openSession();
		// 获限mapper接口实例
		UserMapper userMapper = session.getMapper(UserMapper.class);
		QueryVo queryVo = new QueryVo();
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		queryVo.setIds(ids);
		// 传递Hashmap对象查询用户列表
		List<User> list = userMapper.findUserList(queryVo);
		// 关闭session
		session.close();
	}

	public void testselectUserByList() throws Exception {
		// 获取session
		SqlSession session = sqlSessionFactory.openSession();
		// 获限mapper接口实例
		UserMapper userMapper = session.getMapper(UserMapper.class);
		// 构造查询条件List
		List<User> userlist = new ArrayList<User>();
		User user = new User();
		user.setId(1);
		userlist.add(user);
		user = new User();
		user.setId(2);
		userlist.add(user);
		// 传递userlist列表查询用户列表
		List<User> list = userMapper.selectUserByList(userlist);
		System.out.println(list.size() + "");
		// 关闭session
		session.close();
	}

	public void testselectUserByArrayPojo() throws Exception {
		// 获取session
		SqlSession session = sqlSessionFactory.openSession();
		// 获限mapper接口实例
		UserMapper userMapper = session.getMapper(UserMapper.class);
		// 构造查询条件List
		Object[] userlist = new Object[2];
		User user = new User();
		user.setId(1);
		userlist[0] = user;
		user = new User();
		user.setId(2);
		userlist[1] = user;
		// 传递user对象查询用户列表
		List<User> list = userMapper.selectUserByArrayPojo(userlist);
		// 关闭session
		session.close();
	}

	public void testselectUserByArray() throws Exception {
		// 获取session
		SqlSession session = sqlSessionFactory.openSession();
		// 获限mapper接口实例
		UserMapper userMapper = session.getMapper(UserMapper.class);
		// 构造查询条件List
		Object[] userlist = new Object[2];
		userlist[0] = "1";
		userlist[1] = "2";
		// 传递user对象查询用户列表
		List<User> list = userMapper.selectUserByArray(userlist);
		// 关闭session
		session.close();
	}
}
