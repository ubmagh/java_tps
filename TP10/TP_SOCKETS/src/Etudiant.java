import java.io.Serializable;

public class Etudiant implements Serializable {
    private String nom;
    private String prenom;
    private String groupe;

    public Etudiant() {
    }

    public Etudiant(String nom, String prenom, String groupe) {
        this.nom = nom;
        this.prenom = prenom;
        this.groupe = groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getGroupe() {
        return groupe;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
}
