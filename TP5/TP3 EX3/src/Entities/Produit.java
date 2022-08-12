package Entities;

import java.io.Serializable;

public class Produit implements Serializable {

    private String nom;
    private String marque;
    private float prix;
    private String description;
    private int nbrEnStock;


    public Produit(String nom, String marque, float prix, String description, int nbrEnStock) {
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.description = description;
        this.nbrEnStock = nbrEnStock;
    }

    public String getNom() {
        return nom;
    }

    public String getMarque() {
        return marque;
    }

    public float getPrix() {
        return prix;
    }

    public String getDescription() {
        return description;
    }

    public int getNbrEnStock() {
        return nbrEnStock;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNbrEnStock(int nbrEnStock) {
        this.nbrEnStock = nbrEnStock;
    }

    @Override
    public String toString() {
        return " { " +
                " nom='" + nom + '\'' +
                ", marque='" + marque + '\'' +
                ", prix=" + prix +
                ", description='" + description + '\'' +
                ", nbrEnStock=" + nbrEnStock + " "+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produit produit = (Produit) o;

        if (nom != null ? !nom.equals(produit.nom) : produit.nom != null) return false;
        return marque != null ? marque.equals(produit.marque) : produit.marque == null;
    }

    @Override
    public int hashCode() {
        int result = nom != null ? nom.hashCode() : 0;
        result = 31 * result + (marque != null ? marque.hashCode() : 0);
        return result;
    }
}
