package com.dio_class.devweek.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dio_class.devweek.entities.Incidencia;
import com.dio_class.devweek.service.IncidenciaService;

@RestController
@RequestMapping("/api")
public class IncidenciaController {
	
	@Autowired
	private IncidenciaService service;
	
    @GetMapping("/incidencia")
    public ResponseEntity<List<Incidencia>> findIncidencia(){
    	
        List<Incidencia> listaOcorrencia = service.findAll();
        
        return ResponseEntity.ok().body(listaOcorrencia);
    }

    @GetMapping("/incidencia/{id}")
    public ResponseEntity<Incidencia> findIncidenciaById(@PathVariable Long id){
    	
        Incidencia obj  = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    
    @PostMapping("/incidencia/novo")
    public ResponseEntity<Void> newIncidencia (@RequestBody Incidencia newIncidencia) {
    	
    	Incidencia incidencia = service.save(newIncidencia);
    	
    	URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.replacePath("/api/incidencia/{id}")
				.buildAndExpand(incidencia.getId())
				.toUri();
    	
    	return ResponseEntity.created(uri).build();
    }

}
