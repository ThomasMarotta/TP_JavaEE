package org.iut.montreuil.bean;

import javax.persistence.*;

@Entity
@Table(name = "annonces")
public class Annonce {
    @Id
    @Column(name= "annoncesid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String titre;

    @Column(name = "description")
    private String description;

    @Column(name = "adress")
    private String adresse;

    @Column(name = "mail")
    private String email;

    public Annonce(String titre, String description, String adresse, String email) {
        this.titre = titre;
        this.description = description;
        this.adresse = adresse;
        this.email = email;
    }

    public Annonce(int id, String titre, String description, String adresse, String email) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.adresse = adresse;
        this.email = email;
    }

    public Annonce() {

    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
