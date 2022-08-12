import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServ {

    public static void main(String[] args)  {

        try{
            ServerSocket ss = new ServerSocket(8080);

            Socket s = ss.accept();

            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            int a = is.read();
            a+=5;
            os.write(a);
            // s.close(); // close connection
            System.out.print("\n=>Done !");
        }catch( Exception exc){
            System.err.print("Exception : "+exc);
        }

    }

}
