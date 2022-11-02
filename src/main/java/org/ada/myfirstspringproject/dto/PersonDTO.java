package org.ada.myfirstspringproject.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class PersonDTO { //DTO Data Transfer Object: clases de información
    private String id;
    private String name;
    @JsonAlias("last_name") //como en JSON es last_name, uso librería
    private String lastName;
    private String birthday; //dd-mm-aa
    private char gender;
    @JsonAlias("civil_status")
    private String civilStatus;

    public PersonDTO(String id, String name, String lastName, String birthday, char gender, String civilStatus) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        this.gender = gender;
        this.civilStatus = civilStatus;
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
}
