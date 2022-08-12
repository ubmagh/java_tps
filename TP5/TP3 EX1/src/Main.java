import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        String path;
        File file, files[];
        Scanner input = new Scanner(System.in);


        System.out.print("\n\t [i]> Saisissez le chemin : ");
        path = input.nextLine();


        file = new File( path );

        if( !file.exists() ){
            System.out.print("\n\t[!]> Le chemin spécifié n'existe pas !");
            return;
        }
        if( file.isFile() ){
            System.out.print("\n\t[!]> Veuillez donner le chemin d'un repertoire, non pas d'un fichier !");
            return;
        }

        files = file.listFiles();

        System.out.print("\n\t Liste des fichiers et des repertoires du chemin '"+path+"' :\n");
        for (File tmpF : files) {
            printFile(tmpF);

        }

        System.out.print("\n\n\t [i]> End of program !\n");
    }

    public static void printFile(File tmpF){
        System.out.print("\n\t\t " + tmpF.getAbsolutePath());
        if (tmpF.isFile())
            System.out.print("  <File>  ");
        else
            System.out.print("  <DIR>  ");
        System.out.print(tmpF.canRead() ? "r" : "-");
        System.out.print(tmpF.canWrite() ? "w" : "-");
        System.out.print(tmpF.canExecute() ? "e" : "-");
        System.out.print(tmpF.isHidden() ? "h" : "-");

        if( tmpF.isDirectory() ) {
            File files[] = tmpF.listFiles();
            for( File f: files)
                printFile(f);
        }
    }

}
