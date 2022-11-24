package org.ada.myfirstspringproject.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class PersonDTO { //DTO Data Transfer Object: objetos para llevar informacion entre capas, Defino los campos necesarioa pra crear esa persona y recibirla como body en la peticion q me estan mandando
    private String id;
    private String name;
    @JsonAlias("last_name") //como en JSON es last_name, uso librería
    private String lastName;
    private String birthday; //dd-mm-aa
    private char gender;
    @JsonAlias("civil_status")
    private String civilStatus;

    private List<AcademicDegreeDTO> academicDegreeDTOS;


    public PersonDTO(String id, String name, String lastName, String birthday, char gender, String civilStatus,
                     List<AcademicDegreeDTO> academicDegreeDTOS) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        this.gender = gender;
        this.civilStatus = civilStatus;
        this.academicDegreeDTOS= academicDegreeDTOS;
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

    public String getBirthday() {

        return birthday;
    }

    public char getGender() {

        return gender;
    }

    public String getCivilStatus() {

        return civilStatus;
    }
    public List<AcademicDegreeDTO> getAcademicDegreeDTOS() {
        return academicDegreeDTOS;
    }

}
