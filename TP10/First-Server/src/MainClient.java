import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MainClient {

    public static void main(String[] args) {

        try {
            Socket s = new Socket("localhost", 8080);
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            os.write(8);
            int b = is.read();
            System.out.print(" \n\t revceive :  "+b);
        }catch (Exception exc){
            System.err.print("Exception: "+exc);
        }

    }

}
