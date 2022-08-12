package Entities;

public class Personne {

        private String nom;
        private String prenom;
        private String email;
        public static int num=0;
        /**
         * Default Constructor giving X to all attributes
         */
        public Personne(){
                this.nom = this.prenom = this.email = "X";
        }

        /**
         * Constructor
         * @param nom : String
         * @param prenom : String
         * @param email : String
         */
        public Personne( String nom, String prenom, String email ){
                this.nom = nom;
                this.prenom = prenom;
                this.email = email;
        }


        public void afficher(){
                System.out.printf("\n --> Nom : "+nom);
                System.out.printf("\n --> Prenom : "+prenom);
                System.out.printf("\n --> Email : "+email);
        }


}