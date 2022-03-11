package com.dio_class.devweek.controller;
import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dio_class.devweek.entities.Regiao;
import com.dio_class.devweek.service.RegiaoService;

@RestController
@RequestMapping("/api")
public class RegiaoController {
	
	
	@Autowired
	private RegiaoService service;

    @GetMapping("/regioes")
    public ResponseEntity<List<Regiao>> findAllRegioes(){

    	List<Regiao> allRegioes = service.findAll();
        return ResponseEntity.ok().body(allRegioes);
        
    }

    @GetMapping("regiao/{id}")
    public ResponseEntity<Regiao> findById(@PathVariable Long id){

    	Regiao regiao = service.findById(id);
    	return ResponseEntity.ok().body(regiao);
    }
    
    @PostMapping("regiao/novo")
    public ResponseEntity<Void> newRegiao( @RequestBody Regiao newRegiao){
    	
    	Regiao regiao = service.save(newRegiao);
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.replacePath("/api/regiao/{id}")
				.buildAndExpand(regiao.getId())
				.toUri();
		
		return ResponseEntity.created(uri).build();
    	
    }
    
    @DeleteMapping("regiao/{id}")
    public ResponseEntity<Void> deletaRegiao(@PathVariable Long id) {
    	
    	service.deleteById(id);
    	
    	return ResponseEntity.noContent().build();
    	
    }

}