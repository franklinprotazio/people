package com.protazio.people.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.protazio.people.dto.request.PersonRequestDTO;
import com.protazio.people.dto.response.PersonResponseDTO;
import com.protazio.people.entity.Person;
import com.protazio.people.repository.PersonRepository;
import com.protazio.people.service.PersonService;
import com.protazio.people.util.PersonMapper;

import lombok.RequiredArgsConstructor;

@Service
@Primary
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

	@Autowired
	private final PersonRepository personRepositoty;
	
	private final PersonMapper personMapper;
	
	@Override
	public PersonResponseDTO findById(Long id) {
				
		return personMapper.toPersonDTO(returnPerson(id));			
	}

	@Override
	public List<PersonResponseDTO> findAll() {
		
		return personMapper.toPeopleDTO(personRepositoty.findAll());	
	}

	@Override
	public PersonResponseDTO register(PersonRequestDTO personDTO) {

		Person person = personMapper.toPerson(personDTO);
		
		return personMapper.toPersonDTO(personRepositoty.save(person));
	}

	@Override
	public PersonResponseDTO update(Long id, PersonRequestDTO personDTO) {		
		
		Person person = returnPerson(id);
		
		personMapper.updatePersonData(person, personDTO);
		
		return personMapper.toPersonDTO(personRepositoty.save(person));
	}

	@Override
	public String delete(Long id) {
		personRepositoty.deleteById(id);
		return "Person id: " + id + "deleted";
	}
	
	private Person returnPerson(Long id) {
		return personRepositoty.findById(id)
				.orElseThrow(() -> new RuntimeException("Person wasn't fount on database"));
	}
	

}
