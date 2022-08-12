import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurV3 {
    public static void main(String[] args) {
        try {
            ServerSocket ss=new ServerSocket(8080);
            System.out.println("Attendre une connexion");
            Socket s=ss.accept();
            InputStream is=s.getInputStream();
            OutputStream os=s.getOutputStream();
            ObjectInputStream ois=new ObjectInputStream(is);
            Etudiant e=(Etudiant) ois.readObject();
            System.out.println(e.getNom()+" "+e.getPrenom()+" "+e.getGroupe());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
