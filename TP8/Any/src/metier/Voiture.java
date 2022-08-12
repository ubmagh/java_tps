package metier;

public class Voiture {
    private String matricule;
    private String marque;
    private Double prix;

    public Voiture(String matricule,String marque, Double prix) {
        this.marque = marque;
        this.matricule=matricule;
        this.prix = prix;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    @Override
    public String toString() {
        return "Marque: " + marque+" Matricule: "+matricule;
    }
}
