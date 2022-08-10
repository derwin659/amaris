package com.amarispersona.amarispersona.controller;

import com.amarispersona.amarispersona.model.Person;
import com.amarispersona.amarispersona.service.SearchPersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerErrorException;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping({"/v1"})
@Validated
public class SearchPersonaController {
    private static final Logger logger = LoggerFactory.getLogger(SavePersonaController.class);

    private final SearchPersonService searchPersonService;
    private final String MENSAJE="Esta persona no se encuentra en la base de datos ";
    private final String ERROR="Ha ocurrido un error";
    private final String ERROR_REQUEST="Error en  el request";
    private final String ERROR_SERVER="Error en  el servicio";
    private final String ERRORINGRESO="Solo se debe ingresar C para una Cedula o P para pasaporte en typeDocument, para poder guardar en base de datos";


    public SearchPersonaController(SearchPersonService searchPersonService) {
        this.searchPersonService = searchPersonService;
    }

    @RequestMapping(value = {"/searchperson"}, method = {RequestMethod.GET}, produces = {"application/json"})
    public ResponseEntity<?> login(@RequestParam String typeDocument, @RequestParam String numberDocument) throws Exception {
        if ((typeDocument.length() == 1) && (typeDocument.toLowerCase().equals("c") || typeDocument.toLowerCase().equals("p"))) {
            try {
                Optional<Person> person= Optional.ofNullable(this.searchPersonService.searchPerson(typeDocument.toLowerCase(), numberDocument));
                if(person.isPresent()){
                    return new ResponseEntity<>(person, HttpStatus.OK);
                }else{
                    return new ResponseEntity<>(MENSAJE, HttpStatus.NOT_FOUND);
                }

            } catch (ServerErrorException e) {
                logger.info(ERROR_SERVER + e.getMessage());
                return new ResponseEntity<>(ERROR_SERVER, HttpStatus.INTERNAL_SERVER_ERROR);
            }  catch (NullPointerException e) {
                logger.info(ERROR_REQUEST+ e.getMessage());
                return new ResponseEntity<>(ERROR_REQUEST, HttpStatus.NOT_FOUND);
            }
            catch (NoSuchElementException e) {
                logger.info("Ha ocurrido un error" + e.getMessage());
                return new ResponseEntity<>("Error en  el request ", HttpStatus.NOT_FOUND);
            }
            catch (Exception e) {
                logger.info("Ha ocurrido un error" + e.getMessage());
                return new ResponseEntity<>("Error en  el request ", HttpStatus.BAD_REQUEST);
            }

        }
        return null;




    }
}
