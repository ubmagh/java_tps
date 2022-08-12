package Blogic;

public class Produit {

    private int id;
    private String name;
    private float price;
    private int qte;
    private Category category;


    public Produit() {
    }

    public Produit(int id, String name, float price, int qte, Category category) {
        this.id=  id;
        this.name = name;
        this.price = price;
        this.qte = qte;
        this.category = category;
    }

    public Produit(String name, float price, int qte, Category category) {
        this.name = name;
        this.price = price;
        this.qte = qte;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }
}
