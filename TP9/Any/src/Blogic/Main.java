package Blogic;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        IMetierImp imp = new IMetierImp();

        // Add
        /*
        Category c1 = new Category("Workstatio", null);
        Category c2 = new Category("Accessoires", null);
        Category c3 = new Category("Gaming", null);
        imp.addCategory(c1);
        imp.addCategory(c2);
        imp.addCategory(c3);
        */

        List<Category> categories = imp.getAllCategories();

        for(Category c:categories){
            System.out.print("\n\t ==> Categorie :  "+c.getId()+"-"+c.getName());
        }

        // adding products
        /*
        imp.addProduit( new Produit( "produit1", 12999.99f, 10, categories.get(0))) ;
        imp.addProduit( new Produit( "produit2", 13999.99f, 20, categories.get(1))) ;
        imp.addProduit( new Produit( "produit3", 14999.99f, 30, categories.get(2))) ;
        */




    }
}
