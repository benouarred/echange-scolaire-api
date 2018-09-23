package com.nej.perso.echange.entities;


import javax.persistence.*;


@Entity(name = "test")
@Cacheable(false)
public class Test {

    @Id
    private int id;

    @Column(name = "code")
    private String code;

    @Column(name = "libelle")
    private String libelle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
