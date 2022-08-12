package Entities;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import jdk.nashorn.internal.objects.annotations.Property;

import java.util.Properties;

public class Personne  {
    private int id;
    private StringProperty nom;
    private StringProperty prenom;
    private StringProperty adresse;
    private StringProperty email;
    private StringProperty tel;
    private StringProperty fonction;


    public Personne(int id, String nom, String prenom, String adresse, String email, String tel, String fonction) {
        this(nom, prenom, adresse, email, tel, fonction);
        this.id = id;
    }

    public Personne(String nom, String prenom, String adresse, String email, String tel, String fonction) {
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom) ;
        this.adresse = new SimpleStringProperty(adresse);
        this.email = new SimpleStringProperty(email);
        this.tel = new SimpleStringProperty(tel);
        this.fonction = new SimpleStringProperty(fonction);
    }

    public  Personne(){
        id=-1;
        nom = new SimpleStringProperty("");
        prenom = new SimpleStringProperty("");
        adresse = new SimpleStringProperty("");
        email = new SimpleStringProperty("");
        tel = new SimpleStringProperty("");
        fonction = new SimpleStringProperty("");
    }

    public boolean hasAllFields(){
        boolean b = getNom().length()>0;
        b &= getPrenom().length()>0;
        b &= getEmail().length()>0;
        b &= getTel().length()>0;
        b &= getAdresse().length()>0;
        b &= getFonction().length()>0;
        return b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Personne personne = (Personne) o;

        return id == personne.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom.get();
    }

    public StringProperty nomProperty() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }

    public String getPrenom() {
        return prenom.get();
    }

    public StringProperty prenomProperty() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom.set(prenom);
    }

    public String getAdresse() {
        return adresse.get();
    }

    public StringProperty adresseProperty() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse.set(adresse);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getTel() {
        return tel.get();
    }

    public StringProperty telProperty() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel.set(tel);
    }

    public String getFonction() {
        return fonction.get();
    }

    public StringProperty fonctionProperty() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction.set(fonction);
    }
}
