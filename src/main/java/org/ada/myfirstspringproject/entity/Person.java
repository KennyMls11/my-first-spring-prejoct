package org.ada.myfirstspringproject.entity;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity//vuelvo la tabla una entidad (clase)//
@Table (name = "person") //defino q tabla voy a estar mapeando//
public class Person {

    @Id //Todas las entidades deben rener un Id//
    private String id;

    @Column (nullable = false)
    private String name;

    @Column (name= "last_name", nullable = false)
    private String lastName;

    @Column (nullable = false)
    private LocalDate birthday;

    private char gender;

    @Column (name= "civil_status", nullable = false)
    private String CivilStatus;

    //los objetos de tipo entidad deben tener como minimo el construstor sin parametros//

    @OneToMany(mappedBy = "person",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)//relacion de uno a muchos, en la entidad secundaria el campo q me esta reprensentando esta relacion es person//
    private List<AcademicDegree> academicDegrees;

    public Person() {
    }

    public Person(String id, String name, String lastName, LocalDate birthday,
                  char gender, String civilStatus, List<AcademicDegree> academicDegrees) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        this.gender = gender;
        CivilStatus = civilStatus;
        this.academicDegrees = academicDegrees;
    }

    public Person(String id, String name, String lastName, LocalDate birthday, char gender, String civilStatus) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        this.gender = gender;
        CivilStatus = civilStatus;
    }

    public List<AcademicDegree> getAcademicDegrees() {
        if (academicDegrees == null){
            academicDegrees= new ArrayList<>();
        }
        return academicDegrees;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public char getGender() {
        return gender;
    }

    public String getCivilStatus() {
        return CivilStatus;
    }
}

