package com.amarispersona.amarispersona.controller;


import com.amarispersona.amarispersona.request.RequestDto;
import com.amarispersona.amarispersona.service.SavePersonService;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ServerErrorException;

import javax.validation.Valid;
import java.util.Locale;
import java.util.NoSuchElementException;

/**
 * En esta clase se crea el acceso para guardar en base de dato, mediante POST
 */
@RestController
@RequestMapping({"/v1"})
@Validated
public class SavePersonaController {
    private static final Logger logger = LoggerFactory.getLogger(SavePersonaController.class);

    private final SavePersonService savePersonService;

    public SavePersonaController(SavePersonService savePersonService) {
        this.savePersonService = savePersonService;
    }

    @RequestMapping(value = {"/saveperson"}, method = {RequestMethod.POST}, consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> savePersona(@RequestBody RequestDto requestDto) throws Exception, NoSuchElementException, ConstraintViolationException {
        if ((requestDto.getTypeDocument().length() == 1) && (requestDto.getTypeDocument().toLowerCase().equals("c") || requestDto.getTypeDocument().toLowerCase().equals("p"))) {
            try {
                this.savePersonService.savePerson(requestDto);
                return new ResponseEntity<>("La persona se ha almacenado exitosamente", HttpStatus.OK);
            } catch (ServerErrorException e) {
                logger.info("Ha ocurrido un error" + e.getMessage());
                return new ResponseEntity<>("Error en  el servicio ", HttpStatus.INTERNAL_SERVER_ERROR);
            } catch (Exception e) {
                logger.info("Ha ocurrido un error" + e.getMessage());
                return new ResponseEntity<>("Error en  el request ", HttpStatus.BAD_REQUEST);
            }

        }
        return new ResponseEntity<>("Solo se debe ingresar C para una Cedula o P para pasaporte en typeDocument, para poder guardar en base de datos", HttpStatus.BAD_REQUEST);




    }
}
