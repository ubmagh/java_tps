import java.io.Serializable;

public class Etudiant implements Serializable {

    private String nom;
    private String prenom;
    private /*transient*/ int note; // transient sert à dire au programme de ne pas serialiser cet attribut + les attribut static ne sont pas serialisés


    public Etudiant(String nom, String prenom, int note) {
        this.nom = nom;
        this.prenom = prenom;
        this.note = note;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getNote() {
        return note;
    }
}
