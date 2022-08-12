package Entities;

public class Questionnaire {

    private String titre;
    private Question questions[]; // max 5 questions


    public Questionnaire( String titre, Question questions[]){
        this.titre = titre;
        this.questions = questions;
    }

    public String toString(){
        int i = 1;
        String str = "\n\t=====> Questionnaire : "+titre;
        for( Question qst : questions){
            str+="\n Q"+i+"): "+qst+"\n";
            i++;
        }
        return str+"\n";
    }

    public String getTitre() {
        return titre;
    }

    public int nbrQsts(){
        return questions.length;
    }

    public Question getQestion( int index ){
        if( index<0 || index>questions.length)
            throw new ArrayIndexOutOfBoundsException();
        return questions[index];
    }

    public int maxScore(){
        int sum = 0;
        for (Question qst: questions)
            sum+= qst.getScore();
        return sum;
    }
}
