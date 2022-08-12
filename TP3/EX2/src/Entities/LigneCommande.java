package Entities;

public class LigneCommande {

    private int quantite;
    private Commande commande;
    private Ordinateur ordinateur;

    public LigneCommande( int qte, Commande cmd, Ordinateur ordi){
        quantite = qte; commande = cmd;   ordinateur = ordi;
    }

    public LigneCommande(){
        quantite=0;
    }

    public String toString() {
        return " LigneCommande { " +
                "quantite=" + quantite +
               // ", commande=" + commande +
                ", ordinateur=" + ordinateur +
                " }";
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Ordinateur getOrdinateur() {
        return ordinateur;
    }

    public void setOrdinateur(Ordinateur ordinateur) {
        this.ordinateur = ordinateur;
    }
}
