import java.io.*;
import java.net.Socket;

public class ServeurThread extends Thread{
    private Socket s;
    private int nbClts;

    public ServeurThread(Socket s,int nbClts) {
        this.s = s;
        this.nbClts=nbClts;
    }

    @Override
    public void run() {
        try {
            InputStream is=s.getInputStream();
            OutputStream os=s.getOutputStream();
            PrintWriter pr=new PrintWriter(os,true);
            InputStreamReader isr=new InputStreamReader(is);
            BufferedReader br=new BufferedReader(isr);
            pr.println("Bienvenue"+nbClts);
            String msg;
            while((msg=br.readLine())!=null){
                System.out.println(msg);
                pr.println("S:"+msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
