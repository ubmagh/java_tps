package Blogic;

import java.util.List;

public class Category {

    private int id;
    private String name;
    private List<Produit> produits;


    public Category() {
    }

    public Category(String name, List<Produit> produits) {
        this.name = name;
        this.produits = produits;
    }

    public Category(int id, String name, List<Produit> produits) {
        this.id = id;
        this.name = name;
        this.produits = produits;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
