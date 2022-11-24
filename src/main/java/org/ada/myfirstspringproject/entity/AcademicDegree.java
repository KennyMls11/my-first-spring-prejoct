package org.ada.myfirstspringproject.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table (name= "academic_degree")
public class AcademicDegree {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY ) /*Defino que el id se va a comportar como un AutoIncremental*/
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String institution;

    @Column (nullable = false)
    private LocalDate date;

    @ManyToOne(fetch = FetchType.EAGER) //cada vez que consulte el titulo, voy a cargar la persona q tengo asociada/
    @JoinColumn (name= "person_id",nullable = false ) // se relaciona con la tabla person por medio del id, y no permito ingresar un titulo sin q este asociado a una persona//
    private Person person;

    public AcademicDegree() { //siempre dejar un constructor vacio para que el framework lo utilice internamente
    }

    public AcademicDegree(String title, String institution, LocalDate date,Person person) {
        this.title = title;
        this.institution = institution;
        this.date = date;
        this.person = person;
    }

    public Integer getId() {

        return id;
    }

    public String getTitle() {

        return title;
    }

    public String getInstitution() {
        return institution;
    }

    public LocalDate getDate() {
        return date;
    }

    public Person getPerson() {
        return person;
    }
}
