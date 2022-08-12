/*
    --> soit definir les methodes abstraites de la classe mère ou rendre cette classe abstraite aussi
    --> les classes abstraites sont utilisées pour unifier un comportement
    -->  on utilise les getters & les setters pour controler l'accès aux attrs, par exemple : faire un traitement avant d'affecter ou de lire les valeurs

    -->
*/

public class Rectangle extends Figure {

    private int longueur;
    private int largeur;

    public Rectangle( int x, int y, int longueur, int largeur){
        super( x, y);
        this.longueur=longueur;
        this.largeur = largeur;
    }

    @Override
    public double calculerPerimetre() {
        return (this.largeur + this.longueur)*2;
    }

    @Override
    public double calculerSurface() {
        return largeur*longueur;
    }

    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public int getLargeur() {
        return largeur;
    }

    @Override
    public String afficher() {
        return super.afficher()+" | largeur : "+largeur+" | longueur : "+longueur+" ";
    }
}

