package Entities;

import java.io.Serializable;

public class Client implements Serializable {

    private String nom;
    private String prenom;
    private String adresse;
    private String tel;
    private String email;


    public Client(String nom, String prenom, String adresse, String tel, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.tel = tel;
        this.email = email;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return " {" +
                " nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + "' " +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (tel != null ? !tel.equals(client.tel) : client.tel != null) return false;
        return email != null ? email.equals(client.email) : client.email == null;
    }

    @Override
    public int hashCode() {
        int result = tel != null ? tel.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}

