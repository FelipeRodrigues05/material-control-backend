package com.edphysics.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edphysics.backend.beans.Materials;
import com.edphysics.backend.beans.Students;
import com.edphysics.backend.dao.StudentsDAO;

@RestController
public class StudentsController {
	
	@Autowired
	private StudentsDAO studentDao;
	
	// LISTA TODOS OS MATERIAIS REGISTRADOS NO BANCO DE DADOS
	@GetMapping("/alunos")
	public ResponseEntity<List<Students>> getAll() {
		List<Students> studentList = (List<Students>) studentDao.findAll();
		
		if(studentList.size() == 0) {
			return ResponseEntity.status(404).build();
		}
		
		return ResponseEntity.ok(studentList);
	}
	
	// MOSTRA TODOS OS DADOS RELACIONADOS AO MATERIAL ESCOLHIDO (INSOMNIA)
	@GetMapping("/alunos/{name}")
	public ResponseEntity<Object> getStudentByName(@PathVariable(value = "name") String name) {
		Students studentResponse = studentDao.findByName(name);
		if(studentResponse == null) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(studentResponse);
	}
	
	// CADASTRA UM NOVO ALUNO NO BANCO DE DADOS (INSOMNIA)
	@PostMapping("/alunos/novo-aluno")
	public ResponseEntity<Students> addStudents(@RequestBody Students newStudent) {
		try {
			studentDao.save(newStudent);
			return ResponseEntity.ok(newStudent);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(403).build();
		}
	}

	
}
