package com.nej.perso.echange.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @JsonIgnore
    private int id;


    @Column(name="uuid")
    private String uuid;

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

    @Column(name="classroom")
    private String classroom;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idFather")
    private Person father;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMother")
    private Person mother;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="idCorrespondent")
    private Person correspondent;


}
