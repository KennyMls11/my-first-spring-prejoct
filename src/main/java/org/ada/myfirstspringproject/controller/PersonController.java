package org.ada.myfirstspringproject.controller;

import org.ada.myfirstspringproject.dto.PersonDTO;
import org.ada.myfirstspringproject.service.PersonService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //etiqueta para comportamiento (me hace el import necesario)
@RequestMapping(path="/persons") //parte adicional de la URL
public class PersonController {

    //inyeccion de dependencias//
    private final PersonService personService;

    public PersonController(PersonService personService) {

        this.personService = personService;
    }

    @PostMapping //etiqueta para request de modulo POST (creación)
    public ResponseEntity create //-->Parametros, que se le van a pedir al cliente que inserte,
        // en este caso a postman//
                         (@RequestHeader(value = "client-id") String clientID,
                          @RequestHeader(value = "user-id") String userID,
                          @RequestBody PersonDTO personDTO) {
        //devuelve status HTTP, (request header → ahora es mandatorio en postman agregarlo)

        PersonDTO createdPersonDTO = personService.create(personDTO);

        return new ResponseEntity(personDTO.getId(), HttpStatus.CREATED);

    }


    @GetMapping //get no necesita body/headers en el postman
    public ResponseEntity retrieve() {
        return new ResponseEntity(personService.retrieveAll(), HttpStatus.OK);
        //la lista va a ser el body, ya convertida
    }


    @GetMapping("/{personId}") /*incluyo un parametro adicional en mi Url, euq va a ser el Id de la persona
    especifica que quiero consultar*/
    /*al definirle el @PathVariable le digo que ese parametro lo voy a sacar de esa variable que
    voy a enviar en el path desde el cliente*/
    public ResponseEntity retrieveById(@PathVariable String personId) {
        try {
            PersonDTO personDTO = personService.retrieveById(personId);

            return new ResponseEntity(personDTO, HttpStatus.OK);
        } catch (Exception e){

            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }


    }



}
