import Entities.*;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String questionnaireTitre, qstTitre, qstDesc, resTitre, resCorr;
        int nbrQuestions=0, qstCounter = 0, resNbr=0, qstScore=0, userScore=0, userChoice=0 ;

        Scanner input = new Scanner(System.in);
        System.out.printf("\n\t #> Saisir le titre du questionnaire : ");
        questionnaireTitre = input.nextLine();

        do {
            System.out.printf("\n\t #> Saisir le nombre de questions : ");
            nbrQuestions = input.nextInt();
            input.nextLine();
        } while ( nbrQuestions<1 || nbrQuestions>5 );


        Question questions []=new Question[nbrQuestions];
        qstCounter=1;
        while (qstCounter<=nbrQuestions){
            System.out.printf("\n\t #> Saisir la question n°"+qstCounter+" : ");
            qstTitre = input.nextLine();
            System.out.printf("\n\t #> Saisir la description de la question n°"+qstCounter+" : ");
            qstDesc = input.nextLine();
            System.out.printf("\n\t #> Le score de la question n°"+qstCounter+" est  : ");
            qstScore = input.nextInt();
            input.nextLine();

            do {
                System.out.printf("\n\t #> Saisir le nombre de reponses de la question n°"+qstCounter+" : ");
                resNbr = input.nextInt();
                input.nextLine();

            }while( resNbr<0 || resNbr>3);

            Reponse reponses [] = new Reponse[resNbr];
            for( int i =1; i<resNbr+1;i++){
                System.out.printf("\n\t #> Saisir la réponse n°"+i+" : ");
                resTitre = input.nextLine();
                System.out.printf("\n\t #> La réponse n°"+i+" est correcte (0->faux, else->true) : ");
                resCorr = input.nextLine();
                reponses[i-1] = new Reponse( resTitre, resCorr!="0");
            }
            questions[qstCounter-1] = new Question( qstTitre, qstDesc, Arrays.copyOf( reponses, resNbr), qstScore  );
            qstCounter++;
        }

        Questionnaire questionnaire = new Questionnaire( questionnaireTitre, questions);

        System.out.printf("\n\t---------------------------------------------------\n\t\t Affichage du questionnaire : \n\t---------------------------------------------------\n");
        System.out.printf(questionnaire+"");
        System.out.printf("\n\t---------------------------------------------------\n\t    Fin de l'Affichage du questionnaire : \n\t---------------------------------------------------\n\n");


        System.out.printf("\n\n\t********************************************\n\t   Section : répondre au questionnaire \n\t********************************************\n\n");
        System.out.printf("\t\t ]|============>    "+questionnaire.getTitre()+"     <============|[");

        for(int i=0; i<questionnaire.nbrQsts(); i++){
            System.out.printf("\n\n\t #> Score = "+userScore);
            System.out.printf("\n\t ###=> Question n°"+(i+1)+" : "+questionnaire.getQestion(i));
            do {
                System.out.printf(" \n\t >> Votre réponse est (numéro de réponse) : ");
                userChoice = input.nextInt();
                input.nextLine();
            }while( userChoice<1 || userChoice>questionnaire.getQestion(i).nbrReponses());

            if( questionnaire.getQestion(i).checkAnswer(userChoice-1) )
                userScore += questionnaire.getQestion(i).getScore();

            System.out.printf(" \t #> La réponse correcte est : "+questionnaire.getQestion(i).getCorrecteAnswer()+"\n\n");
        }


        System.out.printf("\n\n\t**********************************************************\n\t   Fin de la section : répondre au questionnaire : \n\n\t**********************************************************\n");
        System.out.printf("\n\t   Votre score est : "+userScore+"/"+questionnaire.maxScore()+" \n\t**********************************************************\n");

        System.out.printf("\n\n\t++++++++++++++++++++++++++++++++++++++++++++\n\t\t Fin du Programme! \n\t++++++++++++++++++++++++++++++++++++++++++++\n\n");
    }
}
