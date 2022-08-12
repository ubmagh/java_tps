package Blogic;

import com.mysql.cj.protocol.Resultset;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class IMetierImp implements IMetier{

    public void addCategory(Category c){
        Connection conx = ConnectionDB.getConnection();
        try{
            PreparedStatement preparedStatement = conx.prepareStatement("INSERT INTO category(name) VALUES(?)");
            preparedStatement.setString(1, c.getName());
            preparedStatement.executeUpdate();
        }catch(Exception exc){
            System.err.print("\n[IMetierImp::addCategory]Exception> "+exc.getMessage());
            exc.printStackTrace();
        }

    }

    public List<Category> getAllCategories(){
        Connection conx = ConnectionDB.getConnection();
        List<Category> categories = new ArrayList<Category>();
        try{
            PreparedStatement preparedStatement = conx.prepareStatement("SELECT * FROM category");
            ResultSet rs = preparedStatement.executeQuery();
            Category c;
            while(rs.next()){
                c = new Category(  rs.getInt("id"), rs.getString("name"), null );
                categories.add(c);
            }
        }catch(Exception exc){
            System.err.print("\n[IMetierImp::getAllCategories]Exception> "+exc.getMessage());
            exc.printStackTrace();
        }
        return categories;
    }



    public void addProduit( Produit p){
        Connection conx = ConnectionDB.getConnection();
        try{
            PreparedStatement preparedStatement = conx.prepareStatement("INSERT INTO produit( name, price, qte, category_id) VALUES( ?, ?, ?, ?)");
            preparedStatement.setString(1, p.getName());
            preparedStatement.setFloat(2, p.getPrice());
            preparedStatement.setInt(3, p.getQte());
            preparedStatement.setInt(4, p.getCategory().getId());
            preparedStatement.executeUpdate();
        }catch(Exception exc){
            System.err.print("\n[IMetierImp::addProduit]Exception> "+exc.getMessage());
            exc.printStackTrace();
        }
    }

    public Category getCategoryById( int id){
        Connection conx = ConnectionDB.getConnection();
        Category cat=null;
        try{
            PreparedStatement preparedStatement = conx.prepareStatement("SELECT * FROM category WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if( rs.next() )
                cat = new Category( rs.getInt("id"), rs.getString("name"), null);
        }catch(Exception exc){
            System.err.print("\n[IMetierImp::addCategory]Exception> "+exc.getMessage());
            exc.printStackTrace();
        }
        return cat;
    }


    public List<Produit> getProduitsByCategory(Category c){
        Connection conx = ConnectionDB.getConnection();
        List<Produit> produits = new ArrayList<Produit>();
        try{
            PreparedStatement preparedStatement = conx.prepareStatement("SELECT * FROM produit WHERE category_id=?");
            preparedStatement.setInt(1, c.getId());
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                produits.add( new Produit(rs.getInt("id"), rs.getString("name"), rs.getFloat("price"), rs.getInt("qte"), getCategoryById( rs.getInt("category_id") ) ) );
            }
        }catch(Exception exc){
            System.err.print("\n[IMetierImp::getProduitsByCategory]Exception> "+exc.getMessage());
            exc.printStackTrace();
        }
        return produits;
    }




}
