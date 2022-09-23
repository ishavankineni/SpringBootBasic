package com.example.SpringBootBasic.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.SpringBootBasic.model.Email;

public interface EmailService {
	
	List<Email> getEmails();
	
	Email postEmails(Email email);
	
	Email sendEmail(int id);
	
	void deleteEmail(int id);

}
