package com.lhx.mybatis.olddaomybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.lhx.mybatis.po.User;

public class UserDaoImpl implements UserDao {

    private SqlSessionFactory sqlSessionFactory;
    
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	//注入SqlSessionFactory
    public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
       this.setSqlSessionFactory(sqlSessionFactory);
    }
     
    public void insertUser(User user) throws Exception {
       SqlSession sqlSession = sqlSessionFactory.openSession();
       try {
           sqlSession.insert("test.insertUser", user);
           sqlSession.commit();
       } finally{
    	   sqlSession.close();
       }
      
    }

    public User getUserById(int id) throws Exception {
       SqlSession session = sqlSessionFactory.openSession();
       User user = null;
       try {
           //通过sqlsession调用selectOne方法获取一条结果集
           //参数1：指定定义的statement的id,参数2：指定向statement中传递的参数
           user = session.selectOne("test.findUserById", 1);
           System.out.println(user);
                    
       } finally{
           session.close();
       }
       return user;
    }
}