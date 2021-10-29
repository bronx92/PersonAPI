package com.bronx92.personapi.service;

import com.bronx92.personapi.dto.request.PersonDTO;
import com.bronx92.personapi.dto.response.MessageResponseDTO;
import com.bronx92.personapi.entity.Person;
import com.bronx92.personapi.mapper.PersonMapper;
import com.bronx92.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson( PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Success!" + savedPerson.getId())
                .build();
    }
}
