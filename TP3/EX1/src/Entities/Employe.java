package Entities;

public abstract class Employe {

    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private float salaire;

    public Employe(){
        nom = prenom = email = telephone = " --vide-- ";
        salaire = -1;
    }

    public Employe( String nom, String prenom, String email, String telephone, float salaire){
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.salaire = salaire;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getPrenom() {
        return prenom;
    }

    public abstract float calculerSalaire();

    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }

    float getSalaire() {
        return salaire;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return " nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", salaire=" + salaire ;
    }
}
