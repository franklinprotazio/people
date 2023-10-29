package com.protazio.people.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.protazio.people.dto.request.PersonRequestDTO;
import com.protazio.people.dto.response.PersonResponseDTO;
import com.protazio.people.service.PersonService;

@RestController
@RequestMapping(value = "/people")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PersonResponseDTO> findById(@PathVariable (name = "id") Long id) {
		return ResponseEntity.ok().body(personService.findById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<PersonResponseDTO>> findAll(){
		return ResponseEntity.ok().body(personService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<PersonResponseDTO> register(@RequestBody PersonRequestDTO personRequestDTO, UriComponentsBuilder uriBuilder){
		
		PersonResponseDTO personResponseDTO = personService.register(personRequestDTO);
		
		URI uri = uriBuilder.path("/person/{id}").buildAndExpand(personResponseDTO.getId()).toUri();
		
		return ResponseEntity.created(uri).body(personResponseDTO);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<PersonResponseDTO> update(@RequestBody PersonRequestDTO persontDTO, @PathVariable(name = "id")Long id){
		return ResponseEntity.ok().body(personService.update(id, persontDTO));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete(@PathVariable(value = "id") Long id) {
		return ResponseEntity.ok().body(personService.delete(id));
	}
	
}
