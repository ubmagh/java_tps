import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            //établir la connexion avec le serveur
            Socket s=new Socket("localhost",8080);
            InputStream is=s.getInputStream();
            OutputStream os=s.getOutputStream();
            os.write(8);
            int b=is.read();
            System.out.println("b="+b);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
