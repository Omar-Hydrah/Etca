package com.etca.model;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;


@Entity
public class User{
	@Id
	@GeneratedValue
	private Long id;

	@Column(unique=true)
	private String username;

	private String password;

	private String firstName;

	private String lastName;

	public User(){
		
	}

	public User(User user){
		this.id = user.id;
		this.username = user.username;
		this.firstName = user.firstName;
		this.lastName  = user.lastName;
		this.password  = user.password;
	}

	public User(Long id, String username, String password){
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public User(String username, String password){
		this.username = username;
		this.password = password;
	}

	public User(String username, String password, String firstName, String lastName){
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName  = lastName;
	}

	public User(Long id, String username, String password, 
		String firstName, String lastName)
	{
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName  = lastName;
	}



	public Long getId() { return this.id; }
	public void setId(Long id) { this.id = id; }
	public String getUsername() { return this.username; }
	public void setUsername(String username) { this.username = username; }
	public String getPassword() { return this.password; }
	public void setPassword(String password) { this.password = password; }
	public String getFirstName() { return this.firstName; }
	public void setFirstName(String firstName) { this.firstName = firstName; }
	public String getLastName() { return this.lastName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
}