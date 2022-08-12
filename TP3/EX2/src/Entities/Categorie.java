package Entities;

import java.util.ArrayList;
import java.util.Scanner;

public class Categorie {

    private String nom;
    private String description;

    private ArrayList<Ordinateur> ordinateurs;

    public Categorie( String nom, String description){
        this.nom = nom;
        this.description = description;
        ordinateurs = new ArrayList<Ordinateur>();
    }

    public Categorie( String nom, String description, ArrayList<Ordinateur> ordis){
        this.nom = nom;
        this.description = description;
        ordinateurs = ordis;
    }

    public Categorie(){
        nom = description = "-";
        ordinateurs = new ArrayList<Ordinateur>();
    }

    public String toString() {
        return " Categorie { " +
                "nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", ordinateurs=" + ordinateurs +
                " }";
    }

    public void ajouterOrdinateur(Ordinateur newOrdi){
        if( !ordinateurs.contains(newOrdi) ) {
            ordinateurs.add(newOrdi);
            System.out.printf("\n\t#[\"+this.nom+\"]-> ordinateur Inséré !");
        }else
            System.out.printf("![\"+this.nom+\"]-> ordinateur existe déjà dans la liste !");
    }

    public void supprimerOrdinateur(int index){
        if( ordinateurs.size() == 0 ){
            System.out.printf("\n\t["+this.nom+"]-> Aucun ordinateur à supprimer !! ");
            return;
        }

       if ( index<0 || index>ordinateurs.size()) {
           System.out.printf("\n\t[" + this.nom + "]->  indice invalide !! ");
           return;
       }

        ordinateurs.remove(index);
        System.out.printf("\n\t["+this.nom+"]-> ordinateur bien supprimé !!: ");
    }


    public ArrayList<Ordinateur>     rechercherParPrix( float prix){
        ArrayList<Ordinateur> ret = new ArrayList<Ordinateur>();

        ordinateurs.forEach( ordinateur ->{
            if( ordinateur.getPrix()==prix )
                ret.add(ordinateur);
        });

        return ret;
    }

    
    
}
