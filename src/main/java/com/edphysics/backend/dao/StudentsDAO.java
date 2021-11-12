package com.edphysics.backend.dao;

import org.springframework.data.repository.CrudRepository;

import com.edphysics.backend.beans.Students;

public interface StudentsDAO extends CrudRepository<Students, Integer>{
	
	public Students findByName(String name);
}
