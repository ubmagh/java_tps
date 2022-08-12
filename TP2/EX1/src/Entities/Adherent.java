package Entities;

public class Adherent extends Personne {

    private String numAdherent;

    public Adherent ( String nom,
                      String prenom,
                      String email,
                      String tel,
                      int age,
                      String numAdherent){
        super( nom, prenom, email, tel, age );
        this.numAdherent = numAdherent;
    }

    @Override
    public void Afficher() {
        super.Afficher();
        System.out.printf("\n --> Numéro d'adhérent : "+numAdherent);
    }
}
