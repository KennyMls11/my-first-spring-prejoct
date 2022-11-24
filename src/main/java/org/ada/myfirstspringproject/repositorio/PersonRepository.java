package org.ada.myfirstspringproject.repositorio;

import org.ada.myfirstspringproject.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

//Tiene los metodos para gestionar//
//Inversion de control//
public interface PersonRepository extends JpaRepository<Person,String> {

}
