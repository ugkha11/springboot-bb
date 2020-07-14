package com.demo.springbootbb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//Entity
@Entity  //(name="")
@Table(name="user")
public class User
{
	
	@Id  //primary key.
	@GeneratedValue   // auto generate the value for this id field 
	private long id;
	
	@Column(name="USER_NAME", length=50, nullable=false, unique=true)
	private String username;
	
	@Column(name="FIRST_NAME", length=50, nullable=false)
	private String firstname;
	
	@Column(name="LAST_NAME", length=50, nullable=false)
	private String lastname;
	
	@Column(name="EMAIL_ADDRESS", length=50, nullable=false)
	private String email;
	
	@Column(name="ROLE", length=50, nullable=false)
	private String role;
	
	@Column(name="SSN", length=50, nullable=false, unique=true)  //@Column(name="USER_NAME", length=50, nullable=false, unique=true)
	private String ssn;


    //no argument constructor .. JPA will not be happy WITHOUT it.    mandatory
	public User()
	{
		
	}

    //getters and setters       mandatory
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getSsn() {
		return ssn;
	}


	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	
    //fields constructor
	public User(long id, String username, String firstname, String lastname, String email, String role, String ssn) {
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
	}
    
    
    //toString   ..... optionally required for bean logging.
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", role=" + role + ", ssn=" + ssn + "]";
	}
	
	
	
	
	

}
