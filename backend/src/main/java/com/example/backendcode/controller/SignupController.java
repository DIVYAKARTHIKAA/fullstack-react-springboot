package com.example.backendcode.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendcode.tourist.*;
import com.example.backendcode.service.*;

@CrossOrigin("http://localhost:3000")
@RequestMapping
@RestController
public class SignupController {

	
	@Autowired
	private SignupService ss;
	
	/*@GetMapping("/getsignup")
	public List<SignupEntity> getDetails()
	{
		return ss.getSignupDetails();
	}*/
	
	@GetMapping("/getsignup")
	public ResponseEntity<List<SignupEntity>> getDetails()
	{
		try
		{
			List<SignupEntity>Details = new ArrayList<>();
			ss.getSignupDetails().forEach(Details::add);
			if(Details.isEmpty())
			{
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(Details, HttpStatus.OK);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getsignup/{id}")
	public void getData1(@PathVariable("id") int id)
	{
		ss.getData1(id);
	}
	
	@PostMapping("/postsignup")
	public void saveData(@RequestBody SignupEntity se)
	{
		ss.saveData(se);
	}
	
	@PutMapping("/putsignup")
	public void updateData(@RequestBody SignupEntity se,@RequestParam int id)
	{
		se.setId(id);
		ss.updateData(se);
	}
	
	@DeleteMapping("/deletesignup")
	public void deleteData(int id)
	{
		ss.deleteData(id);
	}
	@DeleteMapping("/deletesignup/{id}")
	public void deleteData1(@PathVariable("id") int id)
	{
		ss.deleteData1(id);
	}
}
