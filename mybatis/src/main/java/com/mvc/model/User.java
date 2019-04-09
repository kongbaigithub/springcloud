package com.mvc.model;

import java.util.Date;

public class User {

	private Integer id;
	private String username;
	private String password;
	private Integer useable;
	private Date createtime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getUseable() {
		return useable;
	}
	public void setUseable(Integer useable) {
		this.useable = useable;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", useable=" + useable
				+ ", createtime=" + createtime + "]";
	}
	
}
