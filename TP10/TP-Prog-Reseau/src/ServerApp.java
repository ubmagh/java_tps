import java.io.*;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Hashtable;

public class ServerApp {

    private static int generatedNumber;
    private static ArrayList<TheThread> threads;

    public static void main(String[] args) {

        Hashtable<String,String> players = new Hashtable<String, String>();
        threads = new ArrayList<TheThread>();

        generateNewNumber();

        try{
            ServerSocket ss = new ServerSocket(8080);
            while(true){
                threads.add( new TheThread( ss.accept(), players, generatedNumber) );
                threads.get( threads.size()-1 ).start();
            }
        }catch ( IOException ex){
            System.err.print("\n[ServerApp::main]IOException> "+ex.getMessage());
            ex.printStackTrace();
        }
    }


    public static void broadCastwinner( String name, int tries){
        for( TheThread tr: threads){
            tr.printWinner( name, tries);
        }
    }

    public static void broadCastMessage( String message){
        for( TheThread tr: threads){
            tr.printMessage( message);
        }
    }


    public static void generateNewNumber(){
        generatedNumber = (int) (Math.random()*100 %101) ;
        System.out.printf(" \n\t Generated Number :  "+generatedNumber);
        for( TheThread tr: threads){
            tr.setGeneratedNumber( generatedNumber );
            tr.resetTries();
        }
    }

}
