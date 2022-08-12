package Static;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {

    private static Connection conex;
    static {
        try{
            Class.forName( MyGlobalConfiguration.DRIVERNAME );
            conex =  DriverManager.getConnection( MyGlobalConfiguration.CONNECTIONSTRING, MyGlobalConfiguration.dbusername, MyGlobalConfiguration.dbpassword);
        } catch( Exception exc){
            System.err.print( " [Connection::Class] Exception> "+exc.getMessage()+"\n==> stack : \n"+exc.getStackTrace() );
        }
    };

    public static Connection getConex() {
        return conex;
    }
}
