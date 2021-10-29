package com.bronx92.personapi.service;

import com.bronx92.personapi.dto.MessageResponseDTO;
import com.bronx92.personapi.entity.Person;
import com.bronx92.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson( Person person){
        personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Success!")
                .build();
    }
}
