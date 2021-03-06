package com.etca.model;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
public class User{

	private static final Logger logger = LoggerFactory.getLogger(User.class);

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(unique=true, nullable=false)
	private String username;

	@Column(nullable=false)
	private String password;

	@Column(nullable=false)
	private String firstName;

	@Column(nullable=false)
	private String lastName;

	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	private RoleEnum role = RoleEnum.user;

	public User(){
		
	}

	public User(String username, String password){
		this.username = username;
		this.password = password;
	}

	public User(Long id, String username, String password){
		this(username, password);
		this.id = id;
	}


	public User(String username, String password, String firstName, 
		String lastName, RoleEnum role)
	{
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName  = lastName;
		this.role      = role;
	}

	public User(Long id, String username, String password, 
		String firstName, String lastName, RoleEnum role)
	{
		this(username, password, firstName, lastName, role);
		this.id = id;
	}

	public User(User user){
		this(user.id, user.username, user.password, user.firstName, 
			user.lastName, user.role);
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
	public RoleEnum getRole(){return this.role;}
	public void setRole(RoleEnum role){this.role = role;}

	public boolean hasRole(RoleEnum role){
		if(this.role == role){
			return true;
		}
		return false;
	}

	// Must be an Admin or an Author
	public boolean canCreateContent(){
		boolean result = false;

		if(this.role == RoleEnum.admin || this.role == RoleEnum.author){
			result = true;
		}

		return result;
	}
}