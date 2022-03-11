package com.dio_class.devweek.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio_class.devweek.entities.Incidencia;
import com.dio_class.devweek.repository.IncidenciaRepository;
import com.dio_class.devweek.service.exceptions.ObjectNotFoundException;

@Service
public class IncidenciaService {
	
	@Autowired
	private IncidenciaRepository repository;
	
	public List<Incidencia> findAll (){
		
		return repository.findAll();
	}

	public Incidencia findById(Long id) {
		
		Optional<Incidencia> obj = repository.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Faixa Etária não encontrada! Id: " + id + ". Tipo: " + Incidencia.class));
		
	}

	public Incidencia save(Incidencia newIncidencia) {
		
		newIncidencia.setId(null); // Certificando que o id está nullo

		return repository.save(newIncidencia);
	}
	

}
