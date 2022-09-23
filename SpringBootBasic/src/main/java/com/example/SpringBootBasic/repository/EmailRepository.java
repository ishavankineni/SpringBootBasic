package com.example.SpringBootBasic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringBootBasic.model.Email;
@Repository
public interface EmailRepository extends JpaRepository<Email,Integer>{
		
}
