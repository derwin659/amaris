package com.amarispersona.amarispersona.serviceimpl;

import com.amarispersona.amarispersona.model.Person;
import com.amarispersona.amarispersona.repository.PersonRepository;
import com.amarispersona.amarispersona.request.RequestDto;
import com.amarispersona.amarispersona.service.SavePersonService;
import org.springframework.stereotype.Service;

@Service
public class SavePersonImpl implements SavePersonService {

    private  final PersonRepository personRepository;

    public SavePersonImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void savePerson(RequestDto requestDto) {
        Person person=new Person();
        person.setAddress(requestDto.getAddress());
        person.setCityResidency(requestDto.getCityResidency());
        person.setFirstName(requestDto.getFirstName());
        person.setPhone(requestDto.getPhone());
        person.setFirstLastName(requestDto.getFirstLastName());
        person.setNumberDocument(requestDto.getNumberDocument());
        person.setSecondName(requestDto.getSecondName());
        person.setTypeDocument(requestDto.getTypeDocument());
        person.setSecondLastName(requestDto.getSecondLastName());

        personRepository.save(person);
    }
}
