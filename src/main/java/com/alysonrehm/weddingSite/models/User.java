package com.alysonrehm.weddingSite.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="user")
public class User {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @NotEmpty(message="First name is required!")
	    @Size(min=3, max=30, message="First name must be at least 3 characters")
	    private String firstName;
	    
	    @NotEmpty(message="Last name is required!")
	    @Size(min=3, max=30, message="Last name must be at least 3 characters")
	    private String lastName;
	    
	    @NotEmpty(message="Email is required!")
	    @Email(message="Please enter a valid email!")
	    private String email;
	    
	    @NotEmpty(message="Password is required!")
	    @Size(min=8, max=128, message="Password must be aat least 8 characters")
	    private String password;
	    
	    @Transient
	    @NotEmpty(message="Confirm Password is required!")
	    @Size(min=8, max=128, message="Confirm Password must be at least 8 characters")
	    private String confirmPassword;
	    
		@Column(updatable=false)
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private Date createdAt;
		
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private Date updatedAt;
	  
	    //CONSTRUCTOR
	    public User() {}

	    
	    //GETTERS & SETTERS

	    public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getFirstName() {
			return firstName;
		}


		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}


		public String getLastName() {
			return lastName;
		}


		public void setLastName(String lastName) {
			this.lastName = lastName;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public String getConfirmPassword() {
			return confirmPassword;
		}


		public void setConfirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
		}


		public Date getCreatedAt() {
			return createdAt;
		}


		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}


		public Date getUpdatedAt() {
			return updatedAt;
		}


		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}
	    
	    
		@PreUpdate
		protected void onUpdate() {
			this.updatedAt = new Date();
		}
		

		@PrePersist
		protected void onCreate() {
			this.createdAt = new Date();
		}

}

