package com.amarispersona.amarispersona.service;

import com.amarispersona.amarispersona.model.Person;
import org.springframework.stereotype.Component;

@Component
public interface SearchPersonService {
    Person searchPerson(String typeDocument,String numberDocument);
}
