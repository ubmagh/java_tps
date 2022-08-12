package Classes;
import Entities.Client;
import Interfaces.IMetier;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class MetierClientImpl implements IMetier<Client> {

    private String fileName;
    private List<Client> liste;

    public MetierClientImpl(String fileName, List<Client> liste) {
        this.fileName = fileName;
        this.liste = liste;
    }
    public MetierClientImpl(String fileName) {
        this.fileName = fileName;
        this.liste = new ArrayList<Client>();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<Client> getListe() {
        return liste;
    }

    public void setListe(List<Client> liste) {
        this.liste = liste;
    }


    @Override
    public Client add(Client o)  {
        if( liste.contains(o) ) {
            System.out.print("\n\t [addClient]> le client exist déja dans la liste ");
            return liste.get( liste.indexOf(o));
        }
        liste.add( o );
        return liste.get( liste.size()-1 );
    }

    @Override
    public List<Client> getAll() {
        return liste;
    }

    @Override
    public Client findByNom(String nom) {
        Client [] clients = liste.toArray(new Client[0]);
        for(int i=0; i<clients.length; i++){
            if( clients[i].getNom().contains(nom) ) return liste.get(i);
        }
        return (Client) null;
    }

    @Override
    public void delete(String nom) {
        Client [] clients = liste.toArray(new Client[0]);
        int i=0;
        for( i=0; i<clients.length; i++){
            if( clients[i].getNom().equals(nom) ) {
                liste.remove(clients[i]);
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
            System.out.print(" \n\n\t [Exception] saveAll(clients)> "+e.getMessage());
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

            List<Client> listi = (List<Client>) obj.readObject();
            for( Client p: listi)
                this.liste.add(p);
            obj.close();
            fis.close();
            System.out.print("\n\t\t [i]> ✅ Clients sont tous chargés ");
        }catch( Exception e){
            System.out.print(" \n\n\t [Exception] saveAll(clients)> "+e.getMessage());
        }
    }

}


