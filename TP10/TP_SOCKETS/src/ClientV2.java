import java.io.*;
import java.net.Socket;

public class ClientV2 {
    public static void main(String[] args) {
        try {
            Socket s=new Socket("localhost",8080);
            InputStream is=s.getInputStream();
            OutputStream os=s.getOutputStream();
            InputStreamReader isr=new InputStreamReader(is);
            BufferedReader br=new BufferedReader(isr);
            PrintWriter pr=new PrintWriter(os,true);
            pr.println("Bonjour le serveur je suis un nuveau client");
            String msg=br.readLine();
            System.out.println(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
