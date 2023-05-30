package com.example.backendcode.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.backendcode.repositor.*;
import com.example.backendcode.tourist.*;
@Service
public class Services {
	@Autowired
	private Repositor repos;
	public List<Tourist> getTourist()
	{
		return repos.findAll();
	}
	public Optional<Tourist> getTouristbyId(Integer id)
	{
		return repos.findById(id);
	}
	public ResponseEntity<Tourist> updateTouristbyId(Tourist tourist)
	{
		Optional<Tourist>oldTouristData=repos.findById(tourist.getId());
		if(oldTouristData.isPresent())
		{
			Tourist updateTourist = oldTouristData.get();
			updateTourist.setPlace(tourist.getPlace());
			updateTourist.setName(tourist.getName());
			updateTourist.setEmail(tourist.getEmail());
			updateTourist.setPhone(tourist.getPhone());
			Tourist touristobj = repos.save(updateTourist);
			return new ResponseEntity<Tourist>(touristobj, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	public String DeleteTouristbyId(Integer id)
	{
		repos.deleteById(id);
		return "tour  with id " +id+ " removed !! ";
	}
	public Tourist getTouristbyname(String name)
	{
		return repos.findByName(name);
	}
	public Tourist getTouristbyplace(String place)
	{
		return repos.findByPlace(place);
	}
	public String DeleteTouristAll()
	{
		repos.deleteAll();
		return "All tour has been removed ";
	}
	public Iterable<Tourist> sortTourist(String field)
	  {
		  return repos.findAll(Sort.by(field));
	  }
	  public Tourist saveTourist(Tourist tourist)
	  {
		  return repos.save(tourist);
	  }
	  public Page<Tourist> pagingTourist(int page,int pageSize) {
		  Pageable paging=(Pageable) PageRequest.of(page, pageSize);
		  return repos.findAll(paging);
	  }
	  public Page<Tourist> pagingAndSortingTourist(int offset,int pageSize,String field){
		  Pageable paging = (Pageable) PageRequest.of(offset,  pageSize).withSort(Sort.by(field));
		     return repos.findAll(paging);
	  }
}
