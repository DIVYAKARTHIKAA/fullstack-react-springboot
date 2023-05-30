package com.example.backendcode.service;

import java.util.List;

import com.example.backendcode.tourist.*;

public interface LoginInterface {

	public List<LoginEntity> getLoginDetails();
	public void saveData(LoginEntity le);
	public void updateData(LoginEntity le);
	public void deleteData(String id);
}
