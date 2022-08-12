package Entities;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.sql.Date;

public class Professeur {

    private int id_prof;
    private StringProperty nom;
    private StringProperty prenom;
    private StringProperty cin;
    private StringProperty adresse;
    private StringProperty telephone;
    private StringProperty email;
    private Date date_recrutement;
    private Departement departement;

    public Professeur() {
        this( "", "", "", "", "", "", null );
        this.date_recrutement = new Date( 2000-1900, 1, 17);
    }

    public Professeur( Professeur professeur) {
        this( professeur.getId_prof(), professeur.getNom(), professeur.getPrenom(), professeur.getCin(), professeur.getAdresse(), professeur.getTelephone(), professeur.getEmail(), professeur.getDate_recrutement());
        this.departement = new Departement( professeur.getDepartement() );
    }

    public Professeur( String nom, String prenom, String cin, String adresse, String telephone, String email, Date date_recrutement) {
        this.nom = new SimpleStringProperty( nom);
        this.prenom = new SimpleStringProperty( prenom);
        this.cin = new SimpleStringProperty( cin);
        this.adresse = new SimpleStringProperty( adresse);
        this.telephone = new SimpleStringProperty( telephone);
        this.email = new SimpleStringProperty( email);
        if( date_recrutement!=null )
            this.date_recrutement = new Date(date_recrutement.getYear(), date_recrutement.getMonth(), date_recrutement.getDate());
    }

    public Professeur(int id_prof, String nom, String prenom, String cin, String adresse, String telephone, String email, Date date_recrutement) {
        this( nom, prenom, cin, adresse, telephone, email, date_recrutement);
        this.id_prof = id_prof;
    }

    public Professeur( int id_prof, String nom, String prenom, String cin, String adresse, String telephone, String email, Date date_recrutement, Departement departement) {
        this(id_prof, nom, prenom, cin, adresse, telephone, email, date_recrutement);
        this.departement = departement;
    }

    public Professeur( String nom, String prenom, String cin, String adresse, String telephone, String email, Date date_recrutement, Departement departement) {
        this( nom, prenom, cin, adresse, telephone, email, date_recrutement);
        this.departement = departement;
    }

    public int getId_prof() {
        return id_prof;
    }

    public void setId_prof(int id_prof) {
        this.id_prof = id_prof;
    }

    public String getNom() {
        return nom.get();
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }

    public StringProperty nomProperty() {
        return nom;
    }

    public String getPrenom() {
        return prenom.get();
    }

    public void setPrenom(String prenom) {
        this.prenom.set(prenom);
    }

    public StringProperty prenomProperty() {
        return prenom;
    }

    public String getCin() {
        return cin.get();
    }

    public void setCin(String cin) {
        this.cin.set(cin);
    }

    public StringProperty cinProperty() {
        return cin;
    }

    public String getAdresse() {
        return adresse.get();
    }

    public void setAdresse(String adresse) {
        this.adresse.set(adresse);
    }

    public StringProperty adresseProperty() {
        return adresse;
    }

    public String getTelephone() {
        return telephone.get();
    }

    public void setTelephone(String telephone) {
        this.telephone.set(telephone);
    }

    public StringProperty telephoneProperty() {
        return telephone;
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public StringProperty emailProperty() {
        return email;
    }

    public Date getDate_recrutement() {
        return date_recrutement;
    }

    public void setDate_recrutement(Date date_recrutement) {
        this.date_recrutement.setYear(date_recrutement.getYear());
        this.date_recrutement.setMonth(date_recrutement.getMonth());
        this.date_recrutement.setDate(date_recrutement.getDate());
    }


    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    @Override
    public String toString() {
        return " Professeur: { " +
                "id_prof= " + id_prof +
                ", nom= '" + getNom() + '\'' +
                ", prenom= '" + getPrenom() + '\'' +
                ", cin= '" + getCin() + '\'' +
                ", adresse= '" + getAdresse() + '\'' +
                ", telephone= '" + getTelephone() + '\'' +
                ", email= '" + getEmail() + '\'' +
                ", date_recrutement= " + getDate_recrutement() +
                ", departement= " + departement +
                '}';
    }

    public String getDepartemenetNom(){
        if( departement==null )
            return "";
        return departement.getNom();
    }

    public boolean hasAllFields(){
        boolean t =true;
        t &= getNom().trim().length()>0;
        t &= getPrenom().trim().length()>0;
        t &= getCin().trim().length()>0;
        t &= getEmail().trim().length()>0;
        t &= getTelephone().trim().length()>0;
        t &= getAdresse().trim().length()>0;
        t &= getDate_recrutement() !=null ;
        t &= getDepartement()!=null;
        return t;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Professeur that = (Professeur) o;

        return id_prof == that.getId_prof();
    }

    @Override
    public int hashCode() {
        return id_prof;
    }
}
