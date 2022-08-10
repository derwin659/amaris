package com.amarispersona.amarispersona.serviceimpl;

import com.amarispersona.amarispersona.model.Person;
import com.amarispersona.amarispersona.repository.PersonRepository;
import com.amarispersona.amarispersona.service.SearchPersonService;
import org.springframework.stereotype.Service;

@Service
public class SearchPersonImpl implements SearchPersonService {

    private  final PersonRepository personRepository;

    public SearchPersonImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public Person searchPerson(String typeDocument, String numberDocument) {
        return personRepository.typeDocumentAndNumberDocument(typeDocument,numberDocument);
    }
}
