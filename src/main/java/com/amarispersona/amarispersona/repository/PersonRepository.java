package com.amarispersona.amarispersona.repository;


import com.amarispersona.amarispersona.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person,Long> {


    Person typeDocumentAndNumberDocument(String typeDocument,String numberDocument);
}
