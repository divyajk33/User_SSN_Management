package com.divya.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.divya.entity.StatesEntity;
@Repository
public interface StatesRepository extends JpaRepository<StatesEntity, Serializable> {

}
