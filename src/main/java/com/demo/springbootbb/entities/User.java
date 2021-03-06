package com.demo.springbootbb.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonView;



//Entity
@Entity  //(name="")
@Table(name="user")
//@JsonIgnoreProperties({"firstname","lastname"})  -- static filtering
//@JsonFilter(value = "userFilter")  used for mapping jackson value filtering secction

public class User extends RepresentationModel<User> {
	
	@Id  //primary key.
	@GeneratedValue   // auto generate the value for this id field 
	@JsonView(Views.External.class)
	private long userid;
	
	@NotEmpty(message = "Username is mandatory field. Please provdie username.")
	
	@Column(name="USER_NAME", length=50, nullable=false, unique=true)
	@JsonView(Views.External.class)
	private String username;
	
	@Size(min = 2, message = "FirstName should have at least 2 characters")
	@Column(name="FIRST_NAME", length=50, nullable=false)
	@JsonView(Views.External.class)
	private String firstname;
	
	@Column(name="LAST_NAME", length=50, nullable=false)
	@JsonView(Views.External.class)
	private String lastname;
	
	@Column(name="EMAIL_ADDRESS", length=50, nullable=false)
	@JsonView(Views.External.class)
	private String email;
	
	@Column(name="ROLE", length=50, nullable=false)
	@JsonView(Views.Internal.class)
	private String role;
	
	@Column(name="SSN", length=50, nullable=false, unique=true)  //@Column(name="USER_NAME", length=50, nullable=false, unique=true)
	//@JsonIgnore  -- static filtering
	@JsonView(Views.Internal.class)
	private String ssn;
	                                    //User side is referencing side and Order is the owner side
	@OneToMany(mappedBy = "user")   // we are going to create foreign key element userid coloumn in the Order table.
	@JsonView(Views.Internal.class)
	private List<Order> orders;      // if you see, in general order is the owner of the entire relation.
	
	@Column(name = "address")
	public String address;
	


    

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	//no argument constructor .. JPA will not be happy WITHOUT it.    mandatory
	public User()
	{
		
	}

    //getters and setters       mandatory
	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
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
	
	public User(long userid,
			@NotEmpty(message = "Username is mandatory field. Please provdie username.") String username,
			@Size(min = 2, message = "FirstName should have at least 2 characters") String firstname, String lastname,
			String email, String role, String ssn, List<Order> orders, String address) {
		super();
		this.userid = userid;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
		this.orders = orders;
		this.address = address;
	}
    
    //toString   ..... optionally required for bean logging.
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", firstname=" + firstname + ", lastname="
				+ lastname + ", email=" + email + ", role=" + role + ", ssn=" + ssn + ", orders=" + orders + "]";
	}
	

}
