import javax.swing.text.DefaultEditorKit;
import java.io.*;
import java.util.*;

public class DossierContact {

    //  Clé : Nom  & value = numTel
    private HashMap<String,String> contacts;

    public DossierContact() {
        contacts = new HashMap<String, String>();
        File contactsDIR = new File("Contacts");
        if( (!contactsDIR.exists()) || (contactsDIR.isFile()) )
            contactsDIR.mkdir();
        
        File files [] = contactsDIR.listFiles(); 
        if( files.length>0 ) System.out.print("\n\t [i]> restoration des contacts à partir des fichiers....");
        FileReader fr;
        BufferedReader bufferedReader;
        String Line, nom, num, splitted[];
        for(File f: files){
            try {
                fr= new FileReader(f);
                bufferedReader = new BufferedReader(fr);
                Line = bufferedReader.readLine();
                if( Line.length()==0 ) continue;
                splitted =Line.split("[|]");
                nom = splitted[0];
                num = splitted[1];
                contacts.put(nom, num);
                bufferedReader.close();
                fr.close();
            }catch( Exception e){
                System.out.print("\n\t [!!Constr] Exception> "+e.getMessage());
            }
        }
    }
    public DossierContact(HashMap<String, String> contacts) {
        this.contacts = contacts;
    }

    public String getContactNum( String key){
        return contacts.get(key);
    }

    public Set<String> getKeys() {
        return contacts.keySet();
    }

    public static String getContactFileName(String nomC){
        return "./Contacts/"+nomC.trim().replace(" ","").replaceAll("[<>/*+'\"|&]","")+".txt";
    }

    public boolean AjouterContact(String nom, String numTel){
        if( contacts.values().contains(numTel) ){
            System.out.print("\n\t [!Ajout]> Ce numéro '"+numTel+"' existe déjà dans la liste des contactes .");
            return false;
        }
        contacts.put(nom,numTel);
        // int index = contacts.size()-1;
        String fileName = getContactFileName(nom);

        File file = new File(fileName);
        try {
            if (!file.exists())
                file.createNewFile();
            FileWriter fw = new FileWriter(file);
            fw.write(nom+"|"+numTel);
            fw.close();
        }catch( IOException e){
            System.out.print("\n\t [!!Ajout] Exception> "+e.getMessage());
            return false;
        }
        return true;
    }

    public boolean SupprimerContact(String key){
        if( ! contacts.containsKey(key) ){
            System.out.print("\n\t [!Suppr]> Ce contact '"+key+"' est introuvable .");
            return false;
        }
        if( key.length()==0 ){
            System.out.print("\n\t [!Suppr]> la clé du contact '"+key+"' est invalide .");
            return false;
        }
        contacts.remove( key );
        File remFile = new File( getContactFileName(key) );
        remFile.delete();
        return true;
    }

    public List<String> ChercherContactParNom(String nom){
        Vector<String> indexes = new Vector<String>();
        String [] keySet = contacts.keySet().toArray(new String[0]);
        for(int i=0; i<keySet.length; i++){
            if( keySet[i].toLowerCase().contains(nom.toLowerCase()) ) //non cas sensitive search
                indexes.add(keySet[i]);
        }
        return  indexes.stream().toList();
    }

    public boolean ChangerNumero( String key, String num){
        if( !contacts.containsKey(key) ){
            System.out.print("\n\t [!ChangeNum]> contact introuvable ");
            return false;
        }
        contacts.put(key, num);
        String fileName = getContactFileName(key);
        try {
            File file = new File(fileName);
            FileWriter fw = new FileWriter(file);
            fw.write(key+":"+num);
            fw.close();
        }catch( IOException e){
            System.out.print("\n\t [!!ChangeNum] Exception> "+e.getMessage());
            return false;
        }
        return true;
    }

}
