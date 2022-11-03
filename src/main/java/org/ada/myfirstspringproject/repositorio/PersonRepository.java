package org.ada.myfirstspringproject.repositorio;

import org.ada.myfirstspringproject.dto.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository <Person,String> {
}
