/*

    -->  see Figure.java
    -->  final : keyword is used to declare constants, or to stop from overriding methods on child classes, and also to prevent a class from being inherited
    -->  interface toutes les methodes sont abstraites ==> implemented not extends ==> can contain final || static attrs
    -->  class abstraite a au moin une seul method abstraite
    -->  dans java, les interfaces sont utilisées pour avoir un couplage faible entre les couches ; lorsqu'on modifie une classe cela n'affecte pas graveement les autres composantes
    -->
 */

import java.util.ArrayList;
import java.util.Iterator;

public class Main {


    public static void main(String[] args) {
        Figure f1 = new Rectangle(0,0, 10, 30);
        Figure f2 = new Cercle( 4,5,0);
        System.out.printf(" f1(rect).surface = "+  f1.calculerSurface());

        /*
         --> si on supprime la methode de cacule de la surface de la classe mere, dans ce cas le type Figure ne peut pas calculer la surface d'ou
                pour résoudre ce probleme on fait un casting explicite vers le type de la classe fille. c'est au moment de l'exécution que la methode à executer est cherchée

         -->
         */


        // ArrayList listeF = new ArrayList(); // ArrayList : stock les types premitifs + les objects (classe mere de toutes les classes)
        ArrayList<Figure> listeF = new ArrayList<Figure>();
        listeF.add( f1 );
        listeF.add( f2 );


        System.out.printf("\n\n\t --> affichage 1 : ");
        for( int i=0; i<listeF.size(); i++){
            System.out.println( listeF.get(i).afficher() );
        }

        System.out.printf("\n\n\t --> affichage 2 : ");
        for( Figure f:listeF ){
            System.out.println( f.afficher() );
        }

        System.out.printf("\n\n\t --> affichage 3 : ");
        Iterator<Figure> it = listeF.iterator();
        while( it.hasNext() )
            System.out.printf( it.next().afficher() );


        System.out.printf("\n\n\t --> affichage 4 : ");
        listeF.forEach( (n) -> System.out.printf(n.afficher()) );

    }
}


