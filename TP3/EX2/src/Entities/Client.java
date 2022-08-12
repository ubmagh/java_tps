package Entities;

import java.util.ArrayList;
import java.util.Scanner;

public class Client {

    private String nom;
    private String prenom;
    private String email;
    private String ville;
    private String adresse;
    private String telephone;

    private ArrayList<Commande>  commandes;


    public Client( String n, String p, String em, String vi, String ad, String tel){
        nom = n; prenom = p; email = em; ville = vi; adresse = ad; telephone = tel;
        commandes = new ArrayList<Commande>();
    }

    public Client(){
        nom = prenom = email = ville = adresse = telephone = "-";
        commandes = new ArrayList<Commande>();
    }

    public String toString() {
        return " Client { " +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", ville='" + ville + '\'' +
                ", adresse='" + adresse + '\'' +
                ", telephone='" + telephone + '\'' +
                //", commandes=" + commandes +
                " }";
    }

    public void ajouterCommande(Commande commande){
        if( !commandes.contains(commande) ) {
            commandes.add(commande);
            System.out.printf("\n\t#[\"+this.nom+\"]-> ordinateur Inséré !");
        }else
            System.out.printf("![\"+this.nom+\"]-> ordinateur existe déjà dans la liste !");
    }

    public void supprimerCommande(int index){
        if( commandes.size() == 0 ){
            System.out.printf("\n\t["+this.nom+"]-> Aucune commande à supprimer !! ");
            return;
        }

        if ( index<0 || index>commandes.size()) {
            System.out.printf("\n\t[" + this.nom + "]->  indice invalide !! ");
            return;
        }

        commandes.remove(index);
        System.out.printf("\n\t["+this.nom+"]-> commande bien supprimée !!: ");
    }

    public ArrayList<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(ArrayList<Commande> commandes) {
        this.commandes = commandes;
    }

    public String getNom() {
        return nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
