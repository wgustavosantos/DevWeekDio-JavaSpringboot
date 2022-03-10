package com.dio_class.devweek.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio_class.devweek.entities.Incidencia;
import com.dio_class.devweek.repository.IncidenciaRepository;

@Service
public class IncidenciaService {
	
	@Autowired
	private IncidenciaRepository repository;
	
	public List<Incidencia> findAll (){
		
		List<Incidencia> listaIncidencia = repository.findAll();
		
		if (listaIncidencia.isEmpty())
            return null;
		
		return listaIncidencia;
	}

	public Optional<Incidencia> findById(Long id) {
		return repository.findById(id);
	}

	public Incidencia save(Incidencia newIncidencia) {
		// TODO Auto-generated method stub
		return repository.save(newIncidencia);
	}
	

}
