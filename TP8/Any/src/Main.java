import java.sql.*;

public class Main {

    public static void main(String[] args)  {
        try{
            //pilte jdbc
            Class.forName("com.mysql.cj.jdbc.Driver");
            // create connection
            Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/javatps", "root", "");
            Statement statement = cnx.createStatement();
            //statement.executeUpdate(" INSERT INTO voitures(matricule, marque, prix) VALUES ( 'MAT002', 'BMW D', 99999990.99)"); // insert & update

            ResultSet rs = statement.executeQuery("SELECT * FROM voitures");
            while( rs.next() ){
                System.out.printf("\n\t id : %3d  | matricule : %10s | marque : %20s | prix: %10.2f ",rs.getInt("id"), rs.getString("matricule"),
                        rs.getString("marque"), rs.getDouble("prix")
                );
            }

            System.out.print("\n\n Columns : : :  ");
            ResultSetMetaData rsmd = rs.getMetaData();
            for(int i=1; i<rsmd.getColumnCount(); i++ ){
                System.out.printf("\n  name : %10s  |  type : %10s ", rsmd.getColumnName(i), rsmd.getColumnTypeName(i) );
            }


            // on peut imbriquer la 2 boucle


        } catch(Exception e){
            System.out.printf(" Exception : "+e.getMessage() );
        }


    }

}
