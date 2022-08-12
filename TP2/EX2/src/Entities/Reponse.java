package Entities;

public class Reponse {

    private String titre;
    private boolean correcte;

    public Reponse( String titre, boolean correcte){
        this.titre = titre;
        this.correcte = correcte;
    }

    public boolean isCorrecte(){
        return correcte;
    }

    public String toString(){
        return titre ;
    }

}
