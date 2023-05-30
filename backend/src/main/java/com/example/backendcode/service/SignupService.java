package com.example.backendcode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backendcode.tourist.*;
import com.example.backendcode.repositor.*;

@Service
public class SignupService implements SignupInterface {
	
	@Autowired
	private SignupRepo sr;
	public List<SignupEntity> getSignupDetails()
	{
		return sr.findAll();
	}
	
	public void getData1(int id)
	{
		sr.findById(id);
	}
	
	public void saveData(SignupEntity se)
	{
		sr.save(se);
	}

	public void updateData(SignupEntity se) {
		sr.save(se);		
	}

	public void deleteData(int id) {
		sr.deleteById(id);
	}
	
	public void deleteData1(int id) {
		sr.deleteById(id);
	}

}
