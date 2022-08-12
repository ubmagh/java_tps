import Entities.*;

public class Main {

    public static void main(String[] args) {
        Adherent adherent = new Adherent("AdhNom", "AdhPrenom", "adhrent@object.java", "0698745215", 15, "S00000150");
        Auteur auteur = new Auteur( "AuthNom","AuthPren","Auteur@Object.java", "0542158963", 48, "Auth00054210");
        Livre livre = new Livre( auteur, 15023, " The art of coding ");

        System.out.printf("********* affichage Adhrent :");
        adherent.Afficher();

        System.out.printf("\n\n\n********* affichage livre :");
        livre.Afficher();
    }

}
