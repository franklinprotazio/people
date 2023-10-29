package com.protazio.people.service;

import java.util.List;

import com.protazio.people.dto.request.PersonRequestDTO;
import com.protazio.people.dto.response.PersonResponseDTO;

public interface PersonService {

	PersonResponseDTO findById(Long id);
	
	List<PersonResponseDTO> findAll();
	
	PersonResponseDTO register(PersonRequestDTO RegisterPersonDTO);
	
	PersonResponseDTO update(Long id,  PersonRequestDTO personDTO );
	
	String delete(Long id);
	
}
