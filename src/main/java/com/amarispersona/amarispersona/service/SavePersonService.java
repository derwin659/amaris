package com.amarispersona.amarispersona.service;


import com.amarispersona.amarispersona.model.Person;
import com.amarispersona.amarispersona.request.RequestDto;
import org.springframework.stereotype.Component;

@Component
public interface SavePersonService {
    void savePerson(RequestDto requestDto);
}
