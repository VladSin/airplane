package org.example.airplane.sin.dao.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@Entity
@Table(name = "person")
public class Person {

    @Id
    @Column(name = "PERSON_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    @Pattern(regexp="^[A-Z]+[a-z]+[А-Я]+[а-я]+$",
            message="Username must be alphanumeric with no spaces and first capital")
    private String name;

    @Column(name = "SURNAME")
    @Pattern(regexp="^[A-Z]+[a-z]+[А-Я]+[а-я]+$",
            message="Username must be alphanumeric with no spaces and first capital")
    private String surname;

    @Column(name = "EMAIL")
    @Pattern(regexp="(\\w+)@.*",
            message="Key character not entered")
    private String email;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
