import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurMT {
    private static int nblients;
    public static void main(String[] args) {
        try {
            ServerSocket ss=new ServerSocket(8080);
           while (true){
               System.out.println("Attendre une connexion");
               Socket s=ss.accept();
               nblients++;
               ServeurThread st=new ServeurThread(s,nblients);
               st.start();
           }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
