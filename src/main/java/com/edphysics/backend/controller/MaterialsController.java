package com.edphysics.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edphysics.backend.beans.Materials;
import com.edphysics.backend.dao.MaterialsDAO;

@RestController
@SpringBootApplication
public class MaterialsController {

	@Autowired
	private MaterialsDAO materialDao;
	
	// LISTA TODOS OS MATERIAIS REGISTRADOS NO BANCO DE DADOS
	@GetMapping("/materiais")
	public ResponseEntity<List<Materials>> getAll() {
		List<Materials> materialList = (List<Materials>) materialDao.findAll();
		
		if(materialList.size() == 0) {
			return ResponseEntity.status(404).build();
			
		}
		
		return ResponseEntity.ok(materialList);
	}
	
	// MOSTRA TODOS OS DADOS RELACIONADOS AO MATERIAL ESCOLHIDO (INSOMNIA)
	@GetMapping("/materiais/{tipo}")
	public ResponseEntity<List<Materials>> getMaterialByType(@PathVariable(value = "tipo") String materialType) {
		List<Materials> materialList = materialDao.findByTypeLike(materialType);
		
		if(materialList.size() == 0) {
			return ResponseEntity.status(404).build();
		}
		
		return ResponseEntity.ok(materialList);
	}
	
	// CADASTRA UM NOVO ITEM NO BANCO DE DADOS (INSOMNIA)
	@PostMapping("/materiais/novo-material")
	public ResponseEntity<Materials> addMaterial(@RequestBody Materials newMaterial) {
		try {
			materialDao.save(newMaterial);
			return ResponseEntity.ok(newMaterial);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(403).build();
		}
	}
}
