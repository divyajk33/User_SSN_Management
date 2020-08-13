package com.divya.controller;



import java.util.ArrayList;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.divya.exception.UserNotFoundException;
import com.divya.model.User;
import com.divya.service.UserServiceImpl;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	UserServiceImpl service;
	
	@GetMapping("/users")
	public List<User> getusers() {
		return service.viewUsers();
		 
	}
	@PostMapping("/users/create")
	public void addUser(@RequestBody User user) {

		 service.createUser(user);

	}
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(value="/getUser/ssn/{user_ssn}")
	
	public List<User> viewContact(@PathVariable String user_ssn) {
		List<User>users=service.getUser(user_ssn);
		
		return users;
	}
	
	@RequestMapping("/getStates")
	
	public List<String> populateWebFrameworkList() {
	
	List<String> stateList = new ArrayList<String>();
	stateList=service.viewStates();
	return stateList;
	}
	@PutMapping("/update/{user_ssn}")
    public ResponseEntity<User> updateProduct(@PathVariable(value = "user_ssn") String user_ssn,
          @RequestBody User userDetails) throws UserNotFoundException  {
       User user = service.findBySsn(user_ssn);
       

     user.setFirstName(userDetails.getFirstName());
     user.setLastName(userDetails.getLastName());
     user.setEmail(userDetails.getEmail());
     user.setDob(userDetails.getDob());
     user.setState(userDetails.getState());
       service.updatedUser(user);
      
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/delete/{user_ssn}")
    public ResponseEntity <String>deleteUser(@PathVariable(value = "user_ssn") String user_ssn)
          {
       
      service.deletedUser(user_ssn);
        
        return new ResponseEntity<>("User has been deleted!", HttpStatus.OK);
    }
	


}
