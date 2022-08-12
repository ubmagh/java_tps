package Entities;

public class Question {
    private String titre;
    private String description;
    private Reponse reponses[]; // max 3 reponses
    private int score;

    public Question( String qst, String description, Reponse reponses[], int score){
         titre = qst;
         this.description = description;
        this.reponses = reponses;
        this.score = score;
    }

    public String toString(){
        String qst =  titre+"\n\t   --> "+description+"\n";
        int i=1;
        for( Reponse reponse: reponses ){
            qst += "\n\t"+i+") "+reponse;
            i++;
        }
        return qst;
    }

    public int nbrReponses(){
        return reponses.length;
    }

    public boolean checkAnswer(int reponseIndex){
        if( reponseIndex<0 || reponseIndex>reponses.length)
            throw new ArrayIndexOutOfBoundsException();
        return reponses[reponseIndex].isCorrecte();
    }

    public int getScore() {
        return score;
    }

    public String getCorrecteAnswer(){
        for( int i=0; i< reponses.length; i++)
            if(reponses[i].isCorrecte())
                return (i+1)+") "+reponses[i];
        return "NOTFOUND-404";
    }
}
