package com.nej.perso.echange.entities;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Personne {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name="nom")
    private String nom;

    @Column(name="prenom")
    private String prenom;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name="date_naissance")
    private LocalDate dateNaissance;

    @Column(name="email")
    private String email;

    @Column(name="tel1")
    private String telephonePortable;

    @Column(name="tel2")
    private String telephoneFixe;

    @Column(name="adresse")
    private String adresse;

    @Column(name="type")
    private String typePersonne;

    @Column(name="photo")
    private byte[] photo;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_pere", nullable = false)
    private Personne pere;


    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_mere", nullable = false)
    private Personne mere;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephonePortable() {
        return telephonePortable;
    }

    public void setTelephonePortable(String telephonePortable) {
        this.telephonePortable = telephonePortable;
    }

    public String getTelephoneFixe() {
        return telephoneFixe;
    }

    public void setTelephoneFixe(String telephoneFixe) {
        this.telephoneFixe = telephoneFixe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTypePersonne() {
        return typePersonne;
    }

    public void setTypePersonne(String typePersonne) {
        this.typePersonne = typePersonne;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Personne getPere() {
        return pere;
    }

    public void setPere(Personne pere) {
        this.pere = pere;
    }

    public Personne getMere() {
        return mere;
    }

    public void setMere(Personne mere) {
        this.mere = mere;
    }
}
