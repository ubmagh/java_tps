import Entities.Departement;
import Entities.Professeur;
import Impl.IMetierImplementation;

import java.sql.Date;
import java.util.List;

public class ApplicationTestConsole {

    public static void main(String[] args) {

        IMetierImplementation iMetierImplementation = new IMetierImplementation();

        // Ajouter des départements :
        System.out.print("\n\n\t ==> Insérer deux départements : ");
        Departement dep1 = new Departement( "Dep1");
        Departement dep2 = new Departement("Dep2");
        iMetierImplementation.ajouterDepartement(dep1);
        iMetierImplementation.ajouterDepartement(dep2);
        System.out.print("\n#=>dep1: "+dep1);
        System.out.print("\n#=>dep2: "+dep2);
        System.out.print("\n## Insértion terminée ");

        // modifier les departements Créés
        System.out.print("\n\n\t ==> Modifier les deux départements :   dep1-->dep01  et   dep2-->dep02");
        dep1.setNom("dep01");
        iMetierImplementation.modifierDepartement(dep1);
        dep2.setNom("dep02");
        iMetierImplementation.modifierDepartement(dep2);
        System.out.print("\n#=>dep1: "+dep1);
        System.out.print("\n#=>dep2: "+dep2);
        System.out.print("\n## Modification terminée ");

        // supprimer un departement
        System.out.print("\n\n\t ==> Supprimer le departement dep02");
        iMetierImplementation.supprimerDepartement(dep2);
        dep2 = null;
        System.out.print("\n#=>dep1: "+dep1);
        System.out.print("\n#=>dep2: "+dep2);
        System.out.print("\n## Supprission terminée ");

        // ajouter d'autres departements et afficher la liste des départements
        System.out.print("\n\n\t ==> ajouter d'autres departements et afficher la liste des départements");
        dep2 = new Departement("dep02");
        Departement dep3 = new Departement("dep03");
        Departement dep4 = new Departement("dep04");
        iMetierImplementation.ajouterDepartement(dep2);
        iMetierImplementation.ajouterDepartement(dep3);
        iMetierImplementation.ajouterDepartement(dep4);
        System.out.print("\n#=>dep1: "+dep1);
        System.out.print("\n#=>dep2: "+dep2);
        System.out.print("\n#=>dep3: "+dep3);
        System.out.print("\n#=>dep4: "+dep4);
        System.out.print("\n### Departements ajoutés ");
        List<Departement> departements = iMetierImplementation.getDepartements();
        System.out.print("\n#=>Liste des départements: \n"+departements);

        // Créer des professeurs
        System.out.print("\n\n\t ==> ajouter des professeurs");
        Professeur p1 = new Professeur( "prof1Nom", "prof1Prenom", "prof1Cin", "prof1Adresse", "prof1Tel", "prof1Email", new Date( 2018-1900,10-1,10), dep1 );
        iMetierImplementation.ajouterProfesseur(p1);
        Professeur p2 = new Professeur( "prof2Nom", "prof2Prenom", "prof2Cin", "prof2Adresse", "prof2Tel", "prof2Email", new Date( 2018-1900,11-1,11), dep1 );
        iMetierImplementation.ajouterProfesseur(p2);
        Professeur p3 = new Professeur( "prof3Nom", "prof3Prenom", "prof3Cin", "prof3Adresse", "prof3Tel", "prof3Email", new Date( 2018-1900,12-1,12), dep2 );
        iMetierImplementation.ajouterProfesseur(p3);
        System.out.print("\n#=>prof1: "+p1);
        System.out.print("\n#=>prof2: "+p2);
        System.out.print("\n#=>prof3: "+p3);
        System.out.print("\n### Professeurs ajoutés ");

        // Modifier un professeur
        System.out.print("\n\n\t ==> Modifier un professeur");
        p1.setNom("prof01Nom");
        p1.setPrenom("prof01Prenom");
        p1.setAdresse("Adddressee ");
        p2.setDepartement(dep2);
        p3.setDepartement(dep3);
        iMetierImplementation.modifierProfesseur(p1);
        iMetierImplementation.modifierProfesseur(p2);
        iMetierImplementation.modifierProfesseur(p3);
        System.out.print("\n#=>prof1: "+p1);
        System.out.print("\n#=>prof2: "+p2);
        System.out.print("\n#=>prof3: "+p3);
        System.out.print("\n### Professeur modifié ");

        // supprimer un professeur :
        System.out.print("\n\n\t ==> Créer et supprimer un professeur(4)");
        Professeur p4 = new Professeur( "prof4Nom", "prof4Prenom", "prof4Cin", "prof4Adresse", "prof4Tel", "prof4Email", new Date( 2018-1900,10-1,10), dep4 );
        iMetierImplementation.ajouterProfesseur(p4);
        System.out.print("\n#=>prof4: "+p4);
        System.out.print("\n### Professeur créé ");
        iMetierImplementation.supprimerProfesseur(p4);
        p4 = null;
        System.out.print("\n#=>prof4: "+p4);
        System.out.print("\n### Professeur supprimé ");

        // affecter un Professeur à un departement
        System.out.print("\n\n\t ==> affecter un Professeur à un departement : affeceter le prof1 au departement 4");
        System.out.print("\n### Avant l'affectation ");
        System.out.print("\n#=>prof1: "+p1);
        iMetierImplementation.affecterProfesseurDepartement( p1, dep4);
        System.out.print("\n### après l'affectation ");
        System.out.print("\n#=>prof1: "+p1);
        System.out.print("\n### prof affecté au departement 04");


        // afficher les profs selon un departement
        System.out.print("\n\n\t ==> Afficher les prof d'un departement ");
        System.out.print("\n### les profs du departement dep2 ");
        List<Professeur> profsDep2 = iMetierImplementation.getProfesseursByDepartement(dep2);
        System.out.print("\n#> "+profsDep2);
        System.out.print("\n### les profs du departement dep4 ");
        List<Professeur> profsDep4 = iMetierImplementation.getProfesseursByDepartement(dep4);
        System.out.print("\n#> "+profsDep4);
        System.out.print("\n\t ==> fin de l'Afficher les prof selon le departement ");


        // Afficher la liste des profs
        System.out.print("\n\n\t ==> Afficher la liste de tout les profs ");
        List<Professeur> listDesProfs = iMetierImplementation.getAllProfesseurs();
        System.out.print("\n#> "+listDesProfs);
        System.out.print("\n\t ==>Fin de l' Afficher la liste de tout les profs ");


    }

}
