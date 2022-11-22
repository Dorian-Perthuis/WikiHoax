package com.IA.Promo171.WikiHoax.backend.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;

private String nom;
private String prenom;
private String email;
private String fonction;
private String identifiant;
private String mdp;



public User(Long id, String nom, String prenom, String email, String fonction, String identifiant, String mdp) {
    this.id = id;
    this.nom = nom;
    this.prenom = prenom;
    this.email = email;
    this.fonction = fonction;
    this.identifiant = identifiant;
    this.mdp = mdp;
}



public User(Long id) {
    this.id = id;
}



public String getIdentifiant() {
    return identifiant;
}



public String getMdp() {
    return mdp;
}



}
