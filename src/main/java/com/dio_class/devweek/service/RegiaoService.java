package com.dio_class.devweek.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio_class.devweek.entities.Regiao;
import com.dio_class.devweek.repository.RegiaoRepository;

@Service
public class RegiaoService {
	
	@Autowired
	private RegiaoRepository repository;
	
	public List<Regiao> findAll(){
		return repository.findAll();
	}
	
	public Optional<Regiao> findById(Long id){
		
		return repository.findById(id);
	}

}
