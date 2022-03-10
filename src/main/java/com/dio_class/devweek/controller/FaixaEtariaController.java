package com.dio_class.devweek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio_class.devweek.entities.FaixaEtaria;
import com.dio_class.devweek.service.FaixaEtariaService;

@RestController
@RequestMapping("/api")
public class FaixaEtariaController {

	@Autowired
	private FaixaEtariaService service;

	@GetMapping("/faixaetaria")
	public ResponseEntity<List<FaixaEtaria>> findAllFaixaEtaria() {

		List<FaixaEtaria> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping("/faixaetaria/{id}")
	public ResponseEntity<FaixaEtaria> findByIdFaixaEtaria(@PathVariable Long id) {
		
			
			FaixaEtaria faixaEtaria = service.findByIdFaixaEtaria(id);
		
			return ResponseEntity.ok().body(faixaEtaria);
	}

	@PostMapping("/faixaetaria/novo")
	public FaixaEtaria newFaixaEtaria(@RequestBody FaixaEtaria newFaixa) {
		return service.save(newFaixa);
	}

	@DeleteMapping("/faixaetaria/remover/{id}")
	public ResponseEntity<Void> deleteFaixaEtaria(@PathVariable long id) {
		service.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}

}
