import java.io.*;
import java.net.Socket;

public class ClientV3 {
    public static void main(String[] args) {
        try {
            Socket s=new Socket("localhost",8080);
            InputStream is=s.getInputStream();
            OutputStream os=s.getOutputStream();
            ObjectOutputStream oos=new ObjectOutputStream(os);
            Etudiant e=new Etudiant("nom1","prenom1","GLSID");
            oos.writeObject(e);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
