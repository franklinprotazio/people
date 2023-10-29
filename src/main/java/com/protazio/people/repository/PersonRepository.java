package com.protazio.people.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.protazio.people.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
