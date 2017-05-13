package com.lhx.mybatis.po;

public class OrdersCustom extends Order {
	private String username;
	private String address;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "OrdersCustom [username=" + username + ", address=" + address + ", getId()=" + getId()
				+ ", getUser_id()=" + getUser_id() + ", getNumber()=" + getNumber() + ", getNote()=" + getNote()
				+ ", getCreatetime()=" + getCreatetime() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	

	

}
