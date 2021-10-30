package com.bronx92.personapi.service;

import com.bronx92.personapi.dto.request.PersonDTO;
import com.bronx92.personapi.dto.response.MessageResponseDTO;
import com.bronx92.personapi.entity.Person;
import com.bronx92.personapi.exception.PersonNotFoundException;
import com.bronx92.personapi.mapper.PersonMapper;
import com.bronx92.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.ProviderNotFoundException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<PersonDTO> listAll() {
        List<Person> list = personRepository.findAll();
        return list.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);
        return personMapper.toDTO(person);
    }

    public void delete(Long id) throws PersonNotFoundException {
        verifyIfExists(id);
        personRepository.deleteById(id);
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        /*
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isEmpty()){
            throw new PersonNotFoundException(id);
        }
        */
        return personRepository.findById(id)
                .orElseThrow(
                        () -> new PersonNotFoundException(id)
                );
    }
}
