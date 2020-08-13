package com.divya.service;

import java.util.ArrayList;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;


import com.divya.entity.StatesEntity;
import com.divya.entity.UserEntity;
import com.divya.exception.UserNotFoundException;
import com.divya.model.User;
import com.divya.repository.StatesRepository;
import com.divya.repository.UserRepository;

@Component
public class UserServiceImpl implements UserService {
	@Autowired
UserRepository repo;
	@Autowired
	StatesRepository repo1;
	@Override
	public void createUser(User user) {
		
			
		
				UserEntity entity=new UserEntity();
				BeanUtils.copyProperties(user, entity);
				repo.save(entity);
				
			
		
		
		
		
	}

	@Override
	public List<User> getUser(String user_ssn) {
		List<User>users=new ArrayList<User>();
		
		Optional<UserEntity>findById=repo.findById(user_ssn);
		
		  if(findById.isPresent()) { 
			  UserEntity entity=findById.get();
			  User user=new User();
			  user.setUser_ssn(entity.getUser_ssn());
		user.setFirstName(entity.getFirstName());
		user.setLastName(entity.getLastName());
		user.setGender(entity.getGender());
		user.setEmail(entity.getEmail());
		user.setDob(entity.getDob());
		user.setState(entity.getState());
		users.add(user);
		  } 
		
		  
		 
		return users;
	}

	@Override
	public List<String> viewStates() {
		// TODO Auto-generated method stub
		List<StatesEntity>states=repo1.findAll();
		List<String>stateNames=new ArrayList<String>();
		for(StatesEntity st:states) {
			stateNames.add(st.getState_name());
			
		}
		
		return stateNames;
		
	}

	@Override
	public List<User> viewUsers() {
		List<User>users=new ArrayList<User>();
		List<UserEntity>userentity=repo.findAll();
		userentity.forEach (entity->{
			User user=new User();
			user.setUser_ssn(entity.getUser_ssn());
			user.setFirstName(entity.getFirstName());
			user.setLastName(entity.getLastName());
			user.setGender(entity.getGender());
			user.setDob(entity.getDob());
			user.setState(entity.getState());
			user.setEmail(entity.getEmail());
			
			users.add(user);
		});
		
		return users;
	}

	@Override
	public User findBySsn(String ssn) throws UserNotFoundException{
		Optional<UserEntity> entity=repo.findById(ssn);
		 User user=new User();
		
		 if(entity.isPresent()) { 
			  UserEntity entitys=entity.get();
			 
			  user.setUser_ssn(entitys.getUser_ssn());
		user.setFirstName(entitys.getFirstName());
		user.setLastName(entitys.getLastName());
		user.setGender(entitys.getGender());
		user.setEmail(entitys.getEmail());
		user.setDob(entitys.getDob());
		user.setState(entitys.getState());
		
		  }
		 else {
			 throw new UserNotFoundException("User not found for given ssn"+ssn);
		 }
		
		return user;
	}

	@Override
	public boolean updatedUser(User user) {
		boolean isUpdated=false;
		UserEntity entity=new UserEntity();
		
			BeanUtils.copyProperties(user, entity);
			UserEntity updatedEntity=repo.save(entity);
			if(updatedEntity.getUser_ssn()!=null) {
				isUpdated=true;
			}
			
		
		return isUpdated;
	}

	@Override
	public void deletedUser(String ssn) {
		repo.deleteById(ssn);
		
	}
	
	    
}
