package com.divya.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.divya.entity.UserEntity;
@Repository

public interface UserRepository extends JpaRepository<UserEntity,Serializable>{

}
