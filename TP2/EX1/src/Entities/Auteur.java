package Entities;

public class Auteur extends Personne {

    private String numAuteur;

    public Auteur ( String nom,
                      String prenom,
                      String email,
                      String tel,
                      int age,
                      String numAuteur){
        super( nom, prenom, email, tel, age );
        this.numAuteur = numAuteur;
    }

    @Override
    public void Afficher() {
        super.Afficher();
        System.out.printf("\n --> Numéro d'auteur : "+numAuteur);
    }

}
