package com.edphysics.backend.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.edphysics.backend.beans.Materials;

public interface MaterialsDAO extends CrudRepository<Materials, Integer> {
	
	public List<Materials> findByTypeLike(String type);
}