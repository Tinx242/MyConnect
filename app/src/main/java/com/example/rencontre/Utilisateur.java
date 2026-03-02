package com.example.rencontre;

import java.util.ArrayList;
import java.util.List;

public class Utilisateur {

    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
    private int age;
    private Genre sex;

    public Utilisateur(String nom, String prenom, String email, String motDePasse){
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.age = age;
        this.sex = sex;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getMotPasse() {
        return motDePasse;
    }

    public void setMotPasse(String motPasse) {

        this.motDePasse = motDePasse;
    }
    public int getAge(){

        return age;
    }

    public void setAge(int age){

        this.age = age;
    }

    public Genre getSex(){

        return sex;
    }

    public void setSex(Genre sex){

        this.sex = sex;
    }

}



