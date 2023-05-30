package com.example.backendcode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backendcode.tourist.*;
import com.example.backendcode.repositor.*;

@Service
public class LoginService implements LoginInterface {
	
	@Autowired
	private LoginRepo lr;
	
	public List<LoginEntity> getLoginDetails(){
		return lr.findAll();
	}
	public void saveData(LoginEntity le)
	{
		lr.save(le);
	}
	
	public void updateData(LoginEntity le)
	{
		lr.save(le);
	}
	
	public void deleteData(String id)
	{
		lr.deleteById(id);	
	}

}
