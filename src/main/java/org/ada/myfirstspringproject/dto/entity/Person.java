package org.ada.myfirstspringproject.dto.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity //vuelvo la tabla una entidad (clase)//
@Table (name = "person") //defino q tabla voy a estar mapeando//

public class Person {

    @Id //Todas las entidades deben rener un Id//
    private String id;

    @Column (nullable = false)
    private String name;

    @Column (name= "last_name", nullable = false)
    private String lastName;

    @Column (nullable = false)
    private LocalDateTime birthday;

    private String gender;

    @Column (name= "civil_status", nullable = false)
    private String CivilStatus;

    //los objetos de tipo entidad deben tener como minimo el construstor sin parametros//


    public Person() {
    }

    public Person(String id, String name, String lastName, LocalDateTime birthday, String gender, String civilStatus) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        this.gender = gender;
        CivilStatus = civilStatus;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public String getGender() {
        return gender;
    }

    public String getCivilStatus() {
        return CivilStatus;
    }
}
