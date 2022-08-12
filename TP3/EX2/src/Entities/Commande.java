package Entities;

import java.util.Date;

public class Commande {

    private String reference;
    private String etatCommande;
    private Date dateCommande;
    private Client client;

    public Commande( String ref, String etat, Date date){
        reference = ref;
        etatCommande = etat;
        dateCommande = date;
        client = new Client();
    }

    public Commande( String ref, String etat, Date date, Client clt){
        reference = ref;
        etatCommande = etat;
        dateCommande = date;
        client = clt;
    }

    public Commande(){
        reference = etatCommande = "-";
        dateCommande = new Date();
        client = new Client();
    }

    public String toString() {
        return "Commande { " +
                "reference='" + reference + '\'' +
                ", etatCommande='" + etatCommande + '\'' +
                ", dateCommande=" + dateCommande +
                ", client =" + client +
                " }";
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public String getEtatCommande() {
        return etatCommande;
    }

    public String getReference() {
        return reference;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public void setEtatCommande(String etatCommande) {
        this.etatCommande = etatCommande;
    }

    public boolean equals(Object o){
        Commande odi = (Commande) o;
        return reference==odi.getReference();
    }
}
