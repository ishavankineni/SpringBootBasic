package com.example.SpringBootBasic.service;

import java.util.List;
import java.util.Optional;

import javax.mail.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.SpringBootBasic.model.Email;
import com.example.SpringBootBasic.repository.EmailRepository;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	EmailRepository emailRepository;

	@Autowired
	JavaMailSender javaMailSender;

	@Override
	public List<Email> getEmails() {
		// TODO Auto-generated method stub
		return emailRepository.findAll();
	}

	@Override
	public Email postEmails(Email email) {
		// TODO Auto-generated method stub
		return emailRepository.save(email);
	}

	@Override
	public Email sendEmail(int id) {
		// TODO Auto-generated method stub
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		Optional<Email> email = emailRepository.findById(id);
		if(email.isPresent()){
			Email email_object = email.get();
			email_object.setSend(true);
			emailRepository.save(email_object);
			mailMessage.setFrom(email_object.getSender());
			mailMessage.setTo(email_object.getRecipients());
			mailMessage.setText(email_object.getMessage());
			mailMessage.setSubject("Hola ! This is me practicing spring boot!");
			javaMailSender.send(mailMessage);
			email_object.setSent(true);
			emailRepository.save(email_object);
		}
		return null;
	}

	@Override
	public void deleteEmail(int id) {
		// TODO Auto-generated method stub
		emailRepository.deleteById(id);
	}

}
