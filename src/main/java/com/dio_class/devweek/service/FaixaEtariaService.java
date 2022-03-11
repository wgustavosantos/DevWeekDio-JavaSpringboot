package com.dio_class.devweek.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio_class.devweek.entities.FaixaEtaria;
import com.dio_class.devweek.repository.FaixaEtariaRepository;
import com.dio_class.devweek.service.exceptions.ObjectNotFoundException;

@Service
public class FaixaEtariaService {
	
	@Autowired
	private FaixaEtariaRepository repository;
	
	public FaixaEtaria findByIdFaixaEtaria(Long id) {
		Optional<FaixaEtaria> obj = repository.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Faixa Etária não encontrada! Id: " + id + ". Tipo: " + FaixaEtaria.class));
	}

	public List<FaixaEtaria> findAll() {
		return repository.findAll();
	}

	public FaixaEtaria save(FaixaEtaria newFaixa) {
		
		newFaixa.setId(null); // Certificando que o id está nullo
		
		return repository.save(newFaixa);
	}

	public void deleteById(long id) {
		
		findByIdFaixaEtaria(id);
		
		repository.deleteById(id);
		
	}
	
}
