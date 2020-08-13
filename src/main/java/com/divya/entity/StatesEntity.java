package com.divya.entity;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="states_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatesEntity {
	@Id
	
	private int st_id;
	private String state_name;
	

}
