package com.example.backendcode.tourist;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="login")
public class LoginEntity {
	@Id
	private String user;
	private String pwd;
	
	public LoginEntity(String user, String pwd) {
		super();
		this.user = user;
		this.pwd = pwd;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public LoginEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	
}
