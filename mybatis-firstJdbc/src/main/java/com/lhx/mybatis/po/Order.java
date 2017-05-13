package com.lhx.mybatis.po;

import java.util.Date;
import java.util.List;

public class Order {
	private Integer id;
	private String user_id;
	private Double number;
	private String note;
	private Date createtime;
	
	private User user;
	
	private List<OrderDetail> orderDetails;
	
	
	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Double getNumber() {
		return number;
	}
	public void setNumber(Double number) {
		this.number = number;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", user_id=" + user_id + ", number=" + number + ", note=" + note + ", createtime="
				+ createtime + ", user=" + user + ", orderDetails=" + orderDetails + ", getOrderDetails()="
				+ getOrderDetails() + ", getUser()=" + getUser() + ", getId()=" + getId() + ", getUser_id()="
				+ getUser_id() + ", getNumber()=" + getNumber() + ", getNote()=" + getNote() + ", getCreatetime()="
				+ getCreatetime() + "]";
	}
	
	
	

}
