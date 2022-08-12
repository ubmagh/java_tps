package App;
import Entities.Employer;
import Entities.Personne;

public class Main {
        // Un code doit etre *ouvert* à l'extension & *fermé* à la modification
    /*
            --> la visibilité, par defaut les attrs sont accessibles par les classes dans le meme package
            --> les mots-clés : static & final
            --> Setters & getters
            --> Surcharge : nombre/types des paramétres || type de retour
            --> Heritage
            --> redéfinition (pour la spécialisation & polymorphisme )
            --> polymorphisme : traiter les classes fille d'une manièe unifiée comme type de classe mere; Personne e1 = new employer(); e1.afficher()==> methode de la classe fille
            --> polymorphisme requires redifinition first, else use casting to use variable as child type
            --> all classes extend Object class implicitly
            --> redefining toString method, méthodes magiques ; comme le constructeur, toString appélés automatiquement

            
            -->
     */

    public static void main( String[] args) {
        Personne pers1 = new Personne( "Mag", "Ayoub", "ubmagh@gmail.com");
        Personne pers2 = new Personne();

        System.out.printf("pers 1 :");
        pers1.afficher();

        System.out.printf(" \n\n pers 2 :");
        pers2.afficher();

        Employer e1 = new Employer();
        System.out.printf(" \n\n emp 1 :");
        e1.afficher();
    }

}
