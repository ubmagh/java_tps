package Entities;

public class Ordinateur {

    private String nom;
    private String marque;
    private float prix;
    private String description;
    private int qteStock;

    public Ordinateur( String nom, String marque, float prix, String description, int qte){
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.description = description;
        this.qteStock = qte;
    }

    public Ordinateur(){
        nom = marque = description = "-";
        prix = qteStock = 0;
    }

    public float prixPourQte(int qte){
        return qte * prix;
    }

    /**
     * Comparaison basée sur le nom et la marque de l'ordi
     * @param o : ordinateur
     * @return boolean
     */
    public boolean equals(Object o){
        Ordinateur odi = (Ordinateur) o;
        boolean i = nom==odi.getNom() && marque==odi.getMarque();
        return  i;
    }

    public String toString() {
        return "Ordinateur { " +
                " nom='" + nom + '\'' +
                ", marque='" + marque + '\'' +
                ", prix=" + prix +
                ", description='" + description + '\'' +
                ", qteStock=" + qteStock +
                " }";
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQteStock() {
        return qteStock;
    }

    public String getDescription() {
        return description;
    }

    public void setQteStock(int qteStock) {
        this.qteStock = qteStock;
    }



}
