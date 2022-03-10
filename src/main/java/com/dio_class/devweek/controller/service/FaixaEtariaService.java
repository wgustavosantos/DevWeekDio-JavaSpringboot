package com.dio_class.devweek.controller.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio_class.devweek.entities.FaixaEtaria;
import com.dio_class.devweek.repository.FaixaEtariaRepository;

@Service
public class FaixaEtariaService {
	
	@Autowired
	private FaixaEtariaRepository repository;
	
	public FaixaEtaria findByIdFaixaEtaria(Long id) {
		Optional<FaixaEtaria> obj = repository.findById(id);
		return obj.get();
	}

	public List<FaixaEtaria> findAll() {
		return repository.findAll();
	}

	public FaixaEtaria save(FaixaEtaria newFaixa) {
		
		return repository.save(newFaixa);
	}

	public void deleteById(long id) {
		
		repository.deleteById(id);
		
	}
	
}
