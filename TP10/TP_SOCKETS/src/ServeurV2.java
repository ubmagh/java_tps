import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurV2 {
    public static void main(String[] args) {
        try {
            ServerSocket ss=new ServerSocket(8080);
            System.out.println("Attendre une connexion d'un client");
            Socket s=ss.accept();
            InputStream is=s.getInputStream();
            OutputStream os=s.getOutputStream();
            InputStreamReader isr=new InputStreamReader(is);
            BufferedReader br=new BufferedReader(isr);
            PrintWriter pr=new PrintWriter(os,true);
            String msg=br.readLine();
            System.out.println(s.getInetAddress()+" "+msg);
            pr.println("Merci pour votre message");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
