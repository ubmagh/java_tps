package Entities;

public class Employer extends Personne {

    private int code;

    public  Employer( String nom, String prenom, String email, int code ){
        super( nom,  prenom,  email);
        this.code=code;
    }

    public Employer(){
        this.code=0;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.printf("\n --> code : "+code);
    }



}
