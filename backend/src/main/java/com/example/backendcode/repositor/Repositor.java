package com.example.backendcode.repositor;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.backendcode.tourist.*;
@Repository
public interface Repositor extends PagingAndSortingRepository<Tourist, Integer>,JpaRepository<Tourist, Integer>{
	Tourist findByName(String name);
	Tourist findByPlace(String place);
	public List<Tourist> findByNameStartingWith(String prefix);
	public List<Tourist> findByNameEndingWith(String suffix);
}
