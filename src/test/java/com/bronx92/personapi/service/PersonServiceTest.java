package com.bronx92.personapi.service;

import com.bronx92.personapi.dto.request.PersonDTO;
import com.bronx92.personapi.dto.response.MessageResponseDTO;
import com.bronx92.personapi.entity.Person;
import com.bronx92.personapi.mapper.PersonMapper;
import com.bronx92.personapi.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.bronx92.personapi.utils.PersonUtils.createFakeDTO;
import static com.bronx92.personapi.utils.PersonUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSuccessSavedMessage() {
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        //when(personMapper.toModel(personDTO)).thenReturn(expectedSavedPerson); // Unnecessary stubbings detected.
        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedPerson);
        MessageResponseDTO successMessage = personService.createPerson(personDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO createExpectedSuccessMessage(Person person) {
        return MessageResponseDTO.builder()
                .message("Operation success at registry: " + person.getId())
                .build();
    }

}