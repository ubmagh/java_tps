public class Cercle extends Figure {

    private int rayon;

    public Cercle( int x, int y, int rayon) {
        super( x, y);
        this.rayon = rayon;
    }

    public int getRayon() {
        return rayon;
    }

    public void setRayon(int rayon) {
        this.rayon = rayon;
    }

    @Override
    public double calculerSurface() {
        return rayon*rayon*Math.PI;
    }

    @Override
    public double calculerPerimetre() {
        return Math.PI*this.rayon;
    }

    @Override
    public String afficher() {
        return super.afficher()+ " | rayon : "+rayon+" ";
    }
}
