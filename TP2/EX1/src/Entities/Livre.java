package Entities;

public class Livre {

    private int ISBN;
    private Auteur auteur;
    private String titre;

    public Livre( Auteur auteur, int ISBN, String titre){
        this.auteur = auteur;
        this.ISBN = ISBN;
        this.titre = titre;
    }

    public void Afficher(){
        System.out.printf("\n --> ISBN : "+ISBN);
        System.out.printf("\n --> Titre : "+titre);
        System.out.printf("\n --> Infos de l'auteur : { ");
        auteur.Afficher();
        System.out.printf("\n }\n ");
    }

}
