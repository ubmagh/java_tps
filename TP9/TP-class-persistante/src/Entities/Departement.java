package Entities;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.util.ArrayList;
import java.util.List;

public class Departement {

    private int id_depart;
    private StringProperty nom;
    private List<Professeur> professeurs;


    public Departement() {
        this("");
    }

    public Departement(String nom) {
        this.nom =  new SimpleStringProperty(nom);
        professeurs = new ArrayList<Professeur>();
    }

    public Departement(int id_depart, String nom) {
        this(nom);
        this.id_depart = id_depart;
    }

    public Departement(int id_depart, String nom, List<Professeur> professeurs) {
        this( id_depart, nom);
        this.professeurs = new ArrayList<Professeur>(professeurs);
    }

    public Departement( Departement dep){
        this( dep.getId_depart(), dep.getNom());
    }

    public int getId_depart() {
        return id_depart;
    }

    public void setId_depart(int id_depart) {
        this.id_depart = id_depart;
    }

    public String getNom() {
        return nom.get();
    }

    public void setNom(String nom) {
        this.nom.set( nom );
    }

    public List<Professeur> getProfesseurs() {
        return professeurs;
    }

    public void setProfesseurs(List<Professeur> professeurs) {
        this.professeurs = professeurs;
    }

    @Override
    public String toString() {
        return " Departement : { " +
                "id_depart= " + id_depart +
                ", nom= '" + getNom() + '\'' +
                ", professeurs= " +  professeurs  +
                " } ";
    }

    public StringProperty nomProperty() {
        return nom;
    }

    public boolean hasAllFields(){
        return this.nom.get().trim().length()>0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Departement that = (Departement) o;

        return id_depart == that.id_depart;
    }

    @Override
    public int hashCode() {
        return id_depart;
    }
}
