package com.dio_class.devweek.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio_class.devweek.entities.Incidencia;
import com.dio_class.devweek.repository.IncidenciaRepository;

@RestController
@RequestMapping("/api")
public class IncidenciaController {
	
	@Autowired
	private IncidenciaRepository repository;
	
    @GetMapping("/incidencia")
    public ResponseEntity<List<Incidencia>> findIncidencia(){
        List<Incidencia> listaOcorrencia = repository.findAll();
        if (listaOcorrencia.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
        return new ResponseEntity<>(listaOcorrencia, HttpStatus.OK);
    }

    @GetMapping("/incidencia/{id}")
    public ResponseEntity<Incidencia> findOcorrenciasById(@PathVariable Long id){
    	
        Optional<Incidencia> incidenciaOptional = repository.findById(id);
        
        if (incidenciaOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
        Incidencia incidenciaUnid = incidenciaOptional.get();
        
        return new ResponseEntity<>(incidenciaUnid, HttpStatus.NOT_FOUND);
    }
    
    public Incidencia newIncidencia (@RequestBody Incidencia newIncidencia) {
    	
    	return repository.save(newIncidencia);
    }


}
