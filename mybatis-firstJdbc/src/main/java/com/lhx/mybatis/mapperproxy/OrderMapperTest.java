package com.lhx.mybatis.mapperproxy;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lhx.mybatis.po.Order;
import com.lhx.mybatis.po.OrdersCustom;
import com.lhx.mybatis.po.User;

import junit.framework.TestCase;

public class OrderMapperTest extends TestCase {

	private SqlSessionFactory sqlSessionFactory;

	protected void setUp() throws Exception {
		// mybatis配置文件
		String resource = "SqlMapConfig-MapperProxy.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 使用SqlSessionFactoryBuilder创建sessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	public void testfindOrdersList() throws Exception {
		// 获取session
		SqlSession session = sqlSessionFactory.openSession();
		// 获限mapper接口实例
		OrderMapper orderMapper = session.getMapper(OrderMapper.class);
		// 查询订单信息
		List<OrdersCustom> list = orderMapper.findOrdersList();
		System.out.println(list);
		for (int i = 0, len = list.size(); i < len; i++) {
			System.out.println(list.get(i));
		}
		// 关闭session
		session.close();
	}

	public void testfindOrdersListResultMap() throws Exception {
		// 获取session
		SqlSession session = sqlSessionFactory.openSession();
		// 获限mapper接口实例
		OrderMapper orderMapper = session.getMapper(OrderMapper.class);
		// 查询订单信息
		List<Order> list = orderMapper.findOrdersListResultMap();
		System.out.println(list);
		for (int i = 0, len = list.size(); i < len; i++) {
			System.out.println(list.get(i));
		}
		// 关闭session
		session.close();
	}

	public void testfindOrdersDetailList() throws Exception {
		// 获取session
		SqlSession session = sqlSessionFactory.openSession();
		// 获限mapper接口实例
		OrderMapper orderMapper = session.getMapper(OrderMapper.class);
		// 查询订单信息
		List<Order> list = orderMapper.findOrdersDetailList();
		System.out.println(list);
		for (int i = 0, len = list.size(); i < len; i++) {
			System.out.println(list.get(i));
			
			for (int j = 0, len2 = list.get(i).getOrderDetails().size(); j < len; j++) {
				System.out.println(list.get(i).getOrderDetails().get(j));
			}
		}
		// 关闭session
		session.close();
	}
	
	

}