package com.lhx.mybatis.mapperproxy;

import java.util.List;

import com.lhx.mybatis.po.Order;
import com.lhx.mybatis.po.OrdersCustom;
import com.lhx.mybatis.po.User;

public interface OrderMapper {
	List<OrdersCustom> findOrdersList() throws Exception;

	List<Order> findOrdersListResultMap() throws Exception;

	List<Order> findOrdersDetailList() throws Exception;

}