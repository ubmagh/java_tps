package Impl;

import java.sql.Connection;
import java.sql.DriverManager;


public class SignletonConnexionDB {

    private static String connectionString = "jdbc:mysql://localhost:3306/java_gestion_departements";
    private static String username = "root";
    private static String password = "";

    private static Connection connection;

    static {
        try{
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            connection =  DriverManager.getConnection( connectionString, username, password);
        } catch( Exception exc){
            System.err.print( " [SignletonConnexionDB::Class] Exception> "+exc.getMessage()+"\n==> stack : \n"+exc.getStackTrace() );
        }
    };

    public static Connection getConnection() {
        return connection;
    }
}
