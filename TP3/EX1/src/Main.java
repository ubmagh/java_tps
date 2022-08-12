import Entities.Ingenieur;
import Entities.Manager;

public class Main {

    public static void main(String[] args) {
        Ingenieur ing1 = new Ingenieur( "Maghdaoui", "Ayoub", "ubmagh@gmail.com", "0696625030", 1000000f, "Cloud");
        Manager manager = new Manager( "DOE", "JHON", "jhon@doe.org", "060000000000", 20000f, "Communication");

        System.out.printf("\n\n --> L'ingénieur : \n"+ing1);
        System.out.printf("\n\n --> Le manager : \n"+manager);

        System.out.printf("\n\n");

    }

}
