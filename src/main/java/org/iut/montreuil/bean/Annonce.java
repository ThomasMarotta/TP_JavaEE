package org.iut.montreuil.bean;

public class Annonce {
    private int id;
    private String titre;
    private String description;
    private String adresse;
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
