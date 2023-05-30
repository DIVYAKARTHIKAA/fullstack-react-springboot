package com.example.backendcode.tourist;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="signup")
public class SignupEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String user;
	public SignupEntity(int id, String user, String pwd, String matchpwd) {
		super();
		this.id = id;
		this.user = user;
		this.pwd = pwd;
		this.matchpwd = matchpwd;
		

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public SignupEntity(int id, String pwd, String matchpwd) {
		super();
		this.id = id;
		this.pwd=pwd;
		this.matchpwd=matchpwd;
		
	
	}

	private String pwd;
	private String matchpwd;

	
	public SignupEntity(String pwd, String matchpwd) {
		super();
		this.pwd=pwd;
		this.matchpwd=matchpwd;

	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd=pwd;
	}

	public String getMatchpwd() {
		return matchpwd;
	}

	public void setMatchpwd(String matchpwd) {
		this.matchpwd=matchpwd;
	}

	


	public SignupEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
