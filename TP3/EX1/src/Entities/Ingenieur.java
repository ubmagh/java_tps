package Entities;

public class Ingenieur extends Employe {

    private String specialite;

    public Ingenieur(){
        super();
        specialite = " --vide-- ";
    }

    public Ingenieur( String nom, String prenom, String email, String telephone, float salaire, String specialite){
        super(nom, prenom, email, telephone, salaire);
        this.specialite = specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getSpecialite() {
        return specialite;
    }

    @Override
    public float calculerSalaire() {
        return super.getSalaire()*1.15f;
    }

    @Override
    public String toString() {
        return  " Ingenieur : { " +
                super.toString() +
                ", specialite='" + specialite + '\'' +
                " }";
    }
}
