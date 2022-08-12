public abstract class Figure implements FigureInterface {
    private int centreX;
    private int centreY;

    public Figure( int x, int y){
        centreX = x;
        centreY = y;
    }

    public void setCentreX(int centreX) {
        this.centreX = centreX;
    }

    public void setCentreY(int centreY) {
        this.centreY = centreY;
    }

    public int getCentreX() {
        return centreX;
    }

    public int getCentreY() {
        return centreY;
    }

    @Override
    public String afficher() {
        return " x : "+centreX+" | y : "+centreY+" ";
    }

    public abstract double calculerSurface();
    public abstract double calculerPerimetre();
}
