package com.example.SpringBootBasic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootBasic.model.Email;
import com.example.SpringBootBasic.service.EmailService;

@SpringBootApplication
@RestController
public class SpringBootBasicApplication {
	
	@Autowired
	EmailService emailService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBasicApplication.class, args);
	}

	@GetMapping("/get_emails")
	public List<Email> getEmails() {
		return emailService.getEmails();
	}
	
	@PostMapping("/send_emails/{id}")
	public Email getEmails(@PathVariable int id) {
		return emailService.sendEmail(id);
	}
	
	@PostMapping("/post_emails")
	public Email postEmails(@RequestBody Email email) {
		return emailService.postEmails(email);
	}
	
	@PatchMapping("/patch_emails")
	public Email putEmails(@RequestBody Email email) {
		return emailService.postEmails(email);
	}
	
	@PutMapping("/put_emails")
	public Email patchEmails(@RequestBody Email email) {
		return emailService.postEmails(email);
	}
	
	@DeleteMapping("/delete_emails/{id}")
	public void deleteEmails(@PathVariable int id) {
		emailService.deleteEmail(id);	
	}
	
	

}
