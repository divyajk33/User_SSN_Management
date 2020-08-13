package com.divya.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="USER_REGISTRATION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
	@Id
	@GenericGenerator(name="user_ssn_gen",strategy="com.divya.entity.User_SSN_Generator")
	@GeneratedValue(generator="user_ssn_gen")
	
	private String user_ssn;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;
	private String state;

}
