import java.io.*;
import java.net.Socket;
import java.util.Hashtable;

public class TheThread extends Thread {

    Socket socket;
    Hashtable< String, String> players;
    private int generatedNumber;
    private int tries = 0;
    private String name;
    private String adress;
    PrintWriter pw;
    BufferedReader br;


    TheThread( Socket s, Hashtable< String, String> players, int generatedNumber) throws IOException{
        socket=s;
        this.players = players;
        this.generatedNumber = generatedNumber;
        adress = s.getInetAddress().toString();
        InputStream is = s.getInputStream();
        OutputStream os = s.getOutputStream();
        InputStreamReader isr = new InputStreamReader(is);
        br = new BufferedReader(isr);
        pw = new PrintWriter( os, false);

        pw.println("\r\n****************************************************************");
        pw.println("          Welcome in 'random number Guessing' Game");
        pw.println("   A number between 1 & 100 is generated, guess is right to win");
        pw.println("           Whenever you need to quit, just enter 0  ");
        pw.println("****************************************************************");
        pw.flush();

    }



    public void resetTries(){
        this.tries = 0;
    }


    public void printWinner( String winner, int tries){
        pw.println("\r\n\r\n****************************************************************************");
        pw.println("\t ===> The winner is : '"+winner+"' after "+tries+" tries.");
        pw.println("****************************************************************************");
        pw.println("****************              Game is restarting            ****************");
        pw.println("***  Your tries have been reinitialized, a new number is generated    ******");
        pw.println("****************************************************************************");
        pw.flush();
    }

    public void setGeneratedNumber(int generatedNumber) {
        this.generatedNumber = generatedNumber;
    }

    public void printStatusField(){
        pw.println("\r\n\r\n---------------------------------------------------------------------------------------------------");
        pw.println("   Number of players : "+players.size()+"   |    current player : "+ name+"    |   tries : "+tries);
        pw.print("---------------------------------------------------------------------------------------------------\n");
        pw.flush();
    }

    public void printMessage( String message ){
        pw.print(message);
        pw.flush();
    }


    public void closeSocket(){
        pw.print("\r\n\r\n\t [i]> Exiting..., GoodBye !!");
        pw.flush();
        try {
            ServerApp.broadCastMessage("\r\n\t [i] Player '"+name+"' has left the game !");
            players.remove(adress);
            socket.close();
        }catch ( IOException exc){
            pw.print("\r\n [i]> Can't close connection ! "); pw.flush();
            System.err.print("\n [i]> Can't close connection !");
            System.err.print("\n[Runnable::run]IOException> "+exc.getMessage());
            exc.printStackTrace();
        }
    }

    @Override
    public void run(){
        try {
            pw.print("\r\n [i]> Please enter your name to start : ");
            pw.flush();
            name = br.readLine();
            name.trim();
        }catch( IOException exc ){
            pw.print("\r\n [i]> Reading Issue ! ");
            System.err.print("\r\n [i]> Reading Issue ! ");
            System.err.print("\r\n[Runnable::run]IOException> "+exc.getMessage());
            exc.printStackTrace();
        }
        ServerApp.broadCastMessage("\r\n\r\n\t [i] Player '"+name+"' joined the game !");
        players.put( adress, name);
        int typedInt = -1;
        String typedIntStr="";
        while( socket.isConnected() ){
            try {
                printStatusField();
                pw.print("\r\n[i] Enter the number (between 1 & 100) > ");
                pw.flush();
                typedIntStr = br.readLine().trim();
            }catch( IOException exc){
                if( socket.isClosed() ){
                    closeSocket();
                    return;
                }
                System.err.print("\r\n[Runnable::run]IOException> "+exc.getMessage());
                exc.printStackTrace();
            }
            try {
                typedInt = Integer.parseInt(typedIntStr);
                if( typedInt==0 ){
                    closeSocket();
                }
                if( typedInt == generatedNumber ){
                    pw.print("\r\n\t [i]=> Correct ! You won the current round !!! ("+tries+"tries)");
                    ServerApp.broadCastwinner( name, tries);
                    ServerApp.generateNewNumber();
                }else{
                    tries++;
                    if( typedInt>generatedNumber )
                        pw.print("\r\n\t [i]> Nope too big, try again ! ");
                    else
                        pw.print("\r\n\t [i]> Nope too small, try again ! ");
                    pw.flush();
                }
            }catch( NumberFormatException exc){
                if( socket.isClosed() ){
                    closeSocket();
                    return;
                }
                pw.print("\r\n [i]> Invalide number is entered ! ");
                System.err.print("\r\n[Runnable::run]NumberFormatException> "+exc.getMessage());
                exc.printStackTrace();
            }
        }
    }
}
