package com.example.SpringBootBasic.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter@Setter@ToString@NoArgsConstructor@AllArgsConstructor
public class Email {
	@Id
	private int id;
	private String message;
	private String recipients;
	private String sender;
	private boolean send;
	private boolean sent;
}
