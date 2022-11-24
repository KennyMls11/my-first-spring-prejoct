package org.ada.myfirstspringproject.service;

import org.ada.myfirstspringproject.dto.PersonDTO;
import org.ada.myfirstspringproject.entity.Person;
import org.ada.myfirstspringproject.exceptions.ExistingResourceException;
import org.ada.myfirstspringproject.exceptions.ResourceNotFoundException;
import org.ada.myfirstspringproject.repositorio.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


//la capa de servicios es la q se conecta con la DB para realizar operaciones CRUD//

@Service
public class PersonService {

    private final AcademicDegreeService academicDegreeService;
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    //se inyecta la dependencia con el repositorio personRepository//
    private final PersonRepository personRepository; //atributo de instancia, "inyecto la dependencia"//

    public PersonService(AcademicDegreeService academicDegreeService, PersonRepository personRepository) {
        this.academicDegreeService = academicDegreeService;
        this.personRepository = personRepository; //consturctor para q se puedan instanciar objetos//
    }

    //metodo que va a recibir "la comanda" es decir el Body//
    public PersonDTO create(PersonDTO personDTO) {
        Person person = mapToEntity(personDTO);
        checkForExistingPerson(person.getId());
        person = personRepository.save(person);
        if (!CollectionUtils.isEmpty(personDTO.getAcademicDegreeDTOS())) {
            academicDegreeService.create(personDTO.getAcademicDegreeDTOS(), person);
        }

        return personDTO;
    }

    public List<PersonDTO> retrieveAll() {

        List<Person> persons = personRepository.findAll();
        /*List<PersonDTO> personDTOS = new ArrayList<>();
        for (Person person: persons) {
            PersonDTO personDTO = mapToDTO(person);
            personDTOS.add(personDTO);
        }
        return personDTOS;*/
        return persons.stream()
                .map(person -> mapToDTO(person))//voy a mapear mi persona, q viene en la lista de objetos de la entidad//
                //para cada uno lo mapeo con el metodo maptoDTO y le paso la persona//
                .collect(Collectors.toList());//y cada uno de esos elementos mapeados me los colecte en una lista//
    }


    public PersonDTO retrieveById(String id) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        return mapToDTO(person.get()); /*optional tiene el metodo get para retornar la persona si se encuentra*/
    }

    private PersonDTO mapToDTO(Person person) {

        PersonDTO personDTO = new PersonDTO(person.getId(), person.getName(),
                person.getLastName(), person.getBirthday().toString(), person.getGender(),
                person.getCivilStatus(),academicDegreeService.mapToDTOS(person.getAcademicDegrees()));

        return personDTO;
    }


    private void checkForExistingPerson(String personId) {
        if (personRepository.existsById(personId)) {
            throw new ExistingResourceException();
        }
    }

    private Person mapToEntity(PersonDTO personDTO) {
        Person person = new Person(personDTO.getId(), personDTO.getName(),
                personDTO.getLastName(), LocalDate.parse(personDTO.getBirthday(), DATE_TIME_FORMATTER),
                personDTO.getGender(), personDTO.getCivilStatus());

        return person;
    }
}


