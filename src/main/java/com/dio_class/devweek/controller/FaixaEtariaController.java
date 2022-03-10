package com.dio_class.devweek.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio_class.devweek.entities.FaixaEtaria;
import com.dio_class.devweek.repository.FaixaEtariaRepository;

@RestController
@RequestMapping("/api")
public class FaixaEtariaController {

	@Autowired
	private FaixaEtariaRepository repository;

	@GetMapping("/faixaetaria")
	public ResponseEntity<?> findAllFaixaEtaria() {

		try {
			List<FaixaEtaria> lista = repository.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/faixaetaria/{id}")
	public ResponseEntity<FaixaEtaria> findByIdFaixaEtaria(@PathVariable Long id) {
		try {
			Optional<FaixaEtaria> unidOptional = repository.findById(id);
			if (unidOptional.isPresent()) {
				FaixaEtaria faixaEtariaUnid = unidOptional.get();
				return new ResponseEntity<>(faixaEtariaUnid, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/faixaetaria/novo")
	public FaixaEtaria newFaixaEtaria(@RequestBody FaixaEtaria newFaixa) {
		return repository.save(newFaixa);
	}

	@DeleteMapping("/faixaetaria/remover/{id}")
	public void deleteFaixaEtaria(@PathVariable long id) {
		repository.deleteById(id);
	}

}
