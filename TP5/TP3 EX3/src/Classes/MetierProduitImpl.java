package Classes;
import Entities.Produit;
import Interfaces.IMetier;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IMetier<Produit> {

    private String fileName;
    private List<Produit> liste;

    public MetierProduitImpl(String fileName) {
        this.fileName = fileName;
        this.liste = new ArrayList<Produit>();
    }

    public MetierProduitImpl(String fileName, List<Produit> liste) {
        this.fileName = fileName;
        this.liste = liste;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<Produit> getListe() {
        return liste;
    }

    public void setListe(List<Produit> liste) {
        this.liste = liste;
    }

    @Override
    public Produit add(Produit o)  {
        if( liste.contains(o) ) {
            System.out.printf("\n\t [addProduit]> le produit exist déja dans la liste ");
            return liste.get( liste.indexOf(o));
        }
        liste.add( o );
        return liste.get( liste.size()-1 );
    }

    @Override
    public List<Produit> getAll() {
        return liste;
    }

    @Override
    public Produit findByNom(String nom) {
        Produit [] produits = liste.toArray(new Produit[0]);
        for(int i=0; i<produits.length; i++){
            if( produits[i].getNom().contains(nom) ) return liste.get(i);
        }
        return (Produit) null;
    }

    @Override
    public void delete(String nom) {
        Produit [] produits = liste.toArray(new Produit[0]);
        int i=0;
        for( i=0; i<produits.length; i++){
            if( produits[i].getNom().equals(nom) ) {
                liste.remove(produits[i]);
                break;
            }
        }
    }

    @Override
    public void saveAll() {
        File PersistenceFile = new File(fileName);
        try{
            if( !PersistenceFile.exists() )
                PersistenceFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(PersistenceFile);
            ObjectOutputStream obj =  new ObjectOutputStream(fos);
            obj.writeObject( liste );
            obj.close();
            fos.close();
        }catch( IOException e){
            System.out.print(" \n\n\t [Exception] saveAll(produits)> "+e.getMessage());
        }
    }


    @Override
    public void loadAll() {
        File PersistenceFile = new File(fileName);
        try{
            if( !PersistenceFile.exists() ){
                System.out.print("\n\t\t [i]> Aucun fichier de sauvegarde n'a été trouvé !");
                return;
            }

            FileInputStream fis = new FileInputStream(PersistenceFile);
            ObjectInputStream obj =  new ObjectInputStream(fis);

            List<Produit> listi = (List<Produit>) obj.readObject();
            for( Produit p: listi)
                this.liste.add(p);
            obj.close();
            fis.close();
            System.out.print("\n\t\t [i]> ✅ Produits sont tous chargés ");
        }catch( Exception e){
            System.out.print(" \n\n\t [Exception] saveAll(produits)> "+e.getMessage());
        }
    }
}
