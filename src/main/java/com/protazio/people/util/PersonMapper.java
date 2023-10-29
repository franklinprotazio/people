package com.protazio.people.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.protazio.people.dto.request.PersonRequestDTO;
import com.protazio.people.dto.response.PersonResponseDTO;
import com.protazio.people.entity.Person;

@Component
public class PersonMapper {

	public Person toPerson(PersonRequestDTO personDTO) {
		
		return Person.builder()
				.name(personDTO.getName())
				.cpf(personDTO.getCpf())
				.age(personDTO.getAge())
				.build();		
	}
	
	public PersonResponseDTO toPersonDTO(Person person) {
		return new PersonResponseDTO(person);
	}
	
	public List<PersonResponseDTO> toPeopleDTO(List<Person> peopleList) {
		return peopleList.stream().map(PersonResponseDTO::new).collect(Collectors.toList());
	}
	
	public void updatePersonData(Person person, PersonRequestDTO personDTO) {
		
		person.setName(personDTO.getName());
		person.setCpf(personDTO.getCpf());
		person.setAge(personDTO.getAge());
		
	}
	
}
