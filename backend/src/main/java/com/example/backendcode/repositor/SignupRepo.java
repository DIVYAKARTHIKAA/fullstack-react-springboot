package com.example.backendcode.repositor;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backendcode.tourist.*;

public interface SignupRepo extends JpaRepository<SignupEntity, Integer> {
	
}
