import java.io.*;
import java.util.Arrays;

public class FileIO {

    public static void main(String[] args) {

        File file1 = new File("./"); // chemin relative ou absolu
        File tmp;



        for( String fileName:file1.list() ){

            tmp = new File(file1.getAbsolutePath()+"/"+fileName);
            System.out.printf("\n\t ' "+fileName+" ' --> "+( tmp.isDirectory()?"Directory":"File" ) );

        }

        file1 = new File("./file.txt");
        if( file1.exists() )
            System.out.printf("\n\n\t ==> File 'file.txt' existe !");
        else{
            try {
                file1.createNewFile();
                System.out.print("\n\n\t ==> File 'file.txt' n' existe pas !");
            }catch( Exception e){
                System.out.print("\n\n\t impossible de créer le fichier 'file.txt' !");
            }
            System.out.print(" \n\n\t ==> le fichier 'file.txt' est créé !");
        }


        // Reading files !!
        File dataFile = new File("./data.txt");
        FileReader fileReader;

        try {
            System.out.print("\n\n\t Reading 'data.txt' file ....");
            fileReader = new FileReader(dataFile);
            int c;
            String str = "";
            while ( (c=fileReader.read()) != -1  ){
                str += (char)c;
            }
            System.out.print("\n\t [Reading] résultats de lecture : \n"+str+"\n");
            fileReader.close();

        }catch( IOException e){
            System.out.print("\n\n\t [Exception]> Erreur d'ouverture : "+e.getMessage());
        }


        // lire un fichier binaire !
        File inputF = new File("./1.jpg");
        File outputF = new File( "./2.jpg");
        try {


            System.out.printf("\n\n\n\t ==> Copier l'image '1.jpg' .....");
            FileInputStream finputStream = new FileInputStream(inputF);
            if(outputF.exists())
                outputF.delete();

            FileOutputStream fileOutputStream = new FileOutputStream(outputF);
            int bytee;
            while( (bytee = finputStream.read() ) !=-1 ){
                fileOutputStream.write(bytee);
            }
            finputStream.close();
            fileOutputStream.close();
            System.out.printf("\n\n\t ==> Image copiée ✅");
        }catch( IOException e){
            System.out.printf("\n\n\t [Exception]> exception: "+e.getMessage() );
        }




        // Buffered reader & writer




        // Serialisation & Déserialisation
        System.out.print("\n\n\n =================================================== \n\t Serialisation \n");
        Etudiant e1 = new Etudiant("Ayoub", "Maghdaoui", 18);

        File filePersis = new File("./EtudiantsPersis.dat");

        try{
            if( !filePersis.exists() )
                filePersis.createNewFile();
            FileOutputStream fos = new FileOutputStream(filePersis);
            ObjectOutputStream obj =  new ObjectOutputStream(fos);
            obj.writeObject( e1 );
            obj.close();

        }catch( IOException e){
            System.out.print(" \n\n\t [Exception]> "+e.getMessage());
        }


        System.out.print("\n\n\t==> Deserialisation  : \n\n");
        File ff0 = new File("./EtudiantsPersis.dat");
        Etudiant restored;
        try{
            FileInputStream fis = new FileInputStream(ff0);
            ObjectInputStream ois = new ObjectInputStream(fis);
            restored = (Etudiant) ois.readObject();

            System.out.printf("\n\n\t Etudiant deserialisé : [ Nom: "+restored.getNom()+", Prenom: "+restored.getPrenom()+", Note: "+restored.getNote()+"] . \n\n");

        }catch(Exception e){
            System.out.print("\n\n\t [Exception]> "+e.getMessage());
        }
    }
}