package br.com.braulioti.mapper.custom;

import br.com.braulioti.data.dto.v2.PersonDTOV2;
import br.com.braulioti.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {
    public PersonDTOV2 converEntityToDTO(Person person) {
        PersonDTOV2 dto =  new PersonDTOV2();

        dto.setId(person.getId());
        dto.setAddress(person.getAddress());
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setGender(person.getGender());
        dto.setBirthDate(new Date());

        return dto;
    }

    public Person converDTOToEntity(PersonDTOV2 person) {
        Person entity =  new Person();

        entity.setId(person.getId());
        entity.setAddress(person.getAddress());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setGender(person.getGender());
        // entity.setBirthDate(new Date());

        return entity;
    }
}
