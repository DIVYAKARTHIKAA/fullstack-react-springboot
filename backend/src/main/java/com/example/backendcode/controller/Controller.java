package com.example.backendcode.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.backendcode.service.*;
import com.example.backendcode.tourist.*;

@RestController
@CrossOrigin("http://localhost:3000")
public class Controller {
	@Autowired
	private Services service;
	@PostMapping("/user")
	public Tourist saveTourist(@RequestBody Tourist tourist)
	{
		return service.saveTourist(tourist);
	}
	@GetMapping("/users")
	public ResponseEntity<List<Tourist>> getTourist()
	{
		try
		{
			List<Tourist>TouristList = new ArrayList<>();
			service.getTourist().forEach(TouristList::add);
			if(TouristList.isEmpty())
			{
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(TouristList, HttpStatus.OK);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/user/{id}")
	public ResponseEntity<Tourist> getTouristbyId(@PathVariable Integer id)
	{
		Optional<Tourist>TouristData=service.getTouristbyId(id);
		if(TouristData.isPresent())
		{
			return new ResponseEntity<>(TouristData.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	/*@GetMapping("/user/{name}")
	public ResponseEntity<Tourist> getTouristbyName(@PathVariable String name)
	{
		return new ResponseEntity<>(service.getTouristbyname(name), HttpStatus.OK);
	}
	@GetMapping("/user/{place}")
	public ResponseEntity<Tourist> getTouristbyPlace(@PathVariable String place)
	{
		return new ResponseEntity<>(service.getTouristbyplace(place), HttpStatus.OK);
	}*/
	
	
	@PutMapping("/user/{id}")
	public ResponseEntity<Tourist> updateTouristbyId(@PathVariable Long id,@RequestBody Tourist newTouristData)
	{
		return service.updateTouristbyId(newTouristData);
	}
	@DeleteMapping("/user/{id}")
	public ResponseEntity<HttpStatus> DeleteTouristbyId(@PathVariable Integer id)
	{
		service.DeleteTouristbyId(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	/*@GetMapping("/sortTourist/{field}")
	public Iterable<Tourist> getTouristSorted(@PathVariable("field") String field)
	{
		return service.sortTourist(field);
	}
	@GetMapping(value="/pagingTourist/{pageNo}/{pageSize}")
	Page<Tourist> TouristPaging(@PathVariable("pageNo") int pageno,@PathVariable("pageSize") int pageSize)
	{
		return service.pagingTourist(pageno,pageSize);
	}
	@GetMapping(value = "/pagingSortingTourist/{pageNo}/{pageSize}/{field}")
	Page<Tourist> TouristPagingAndSorting(@PathVariable ("pageNo") int pageno,@PathVariable ("pageSize") int pageSize,@PathVariable ("field")String field) {
		return service.pagingAndSortingTourist(pageno, pageSize,field);

	}*/
}
