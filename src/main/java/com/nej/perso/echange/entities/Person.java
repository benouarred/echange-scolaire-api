package com.nej.perso.echange.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "person")
public class Person {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name="firstname")
    private String firstname;

    @Column(name="lastname")
    private String lastname;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name="birthday")
    private LocalDate birthday;

    @Column(name="email")
    private String email;

    @Column(name="mobilephone")
    private String mobilePhone;

    @Column(name="homePhone")
    private String homePhone;

    @Column(name="adress")
    private String adress;

    @Column(name="type")
    private String type;

    @Column(name="photo")
    private byte[] photo;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idFather")
    private Person father;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMother")
    private Person mother;

    @Column(name="classroom")
    private String classroom;

}
