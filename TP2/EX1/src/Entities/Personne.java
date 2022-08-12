package Entities;

public class Personne {

    private String nom;
    private String prenom;
    private String email;
    private String tel;
    private int age;


    /***
     *
     * @param nom :String
     * @param prenom :String
     * @param email :String
     * @param tel :String
     * @param age :int
     */
    public Personne(  String nom,
             String prenom,
             String email,
             String tel,
             int age){
        this.nom = nom;
        this.prenom = prenom;
        this.email= email;
        this.tel = tel;
        this.age = age;
    }


    public void Afficher(){
        System.out.printf("\n --> Nom : "+nom);
        System.out.printf("\n --> prenom : "+prenom);
        System.out.printf("\n --> Email : "+email);
        System.out.printf("\n --> Téléphone : "+tel);
        System.out.printf("\n --> Age : "+age);
    }

}
