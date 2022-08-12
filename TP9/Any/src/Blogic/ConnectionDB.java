package Blogic;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {

    private static Connection connection;

    static{
        try{
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            connection =  DriverManager.getConnection( "jdbc:mysql://localhost:3306/javatps", "root", "");
        } catch( Exception exc){
            System.err.print( " [Connection::Class] Exception> "+exc.getMessage()+"\n==> stack : \n"+exc.getStackTrace() );
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
