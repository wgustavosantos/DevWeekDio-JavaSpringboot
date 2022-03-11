package com.dio_class.devweek.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio_class.devweek.entities.Regiao;
import com.dio_class.devweek.repository.RegiaoRepository;
import com.dio_class.devweek.service.exceptions.ObjectNotFoundException;

@Service
public class RegiaoService {
	
	@Autowired
	private RegiaoRepository repository;
	
	public List<Regiao> findAll(){
		return repository.findAll();
	}
	
	public Regiao findById(Long id){
		Optional<Regiao> obj = repository.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Região não encontrada! Id: " + id + ". Tipo: " + Regiao.class));
	}

	public Regiao save(Regiao obj) {
		
		obj.setId(null); 
		return repository.save(obj);
	}

	public void deleteById(Long id) {
		
		findById(id);
		repository.deleteById(id);
		
	}

}
