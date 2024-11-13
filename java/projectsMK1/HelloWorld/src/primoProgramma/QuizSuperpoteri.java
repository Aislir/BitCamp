package primoProgramma;
import java.util.Scanner;

public class QuizSuperpoteri {
    public static void main(String[] args) {

        int num1 = 0;
        int num2 = 0;
        String superpotereGiorno = "";
        String forzaPotere = "";
        boolean poteriNascosti = false;
        Scanner input = new Scanner(System.in);

        System.out.println("Benvenuto nel Quiz dei Superpoteri!\n");
        System.out.print("Inserisci il tuo primo numero fortunato: ");
        num1 = input.nextInt();
        System.out.print("Inserisci il tuo secondo numero fortunato: ");
        num2 = input.nextInt();
        System.out.print("Hai poteri nascosti? (true o false): ");
        poteriNascosti = input.nextBoolean();

        if (poteriNascosti){
            int forzaSuperpotere = num1 + num2;
            System.out.println("La tua forza del superpotere e': "+forzaSuperpotere);
            if (forzaSuperpotere % 2 == 0){
                System.out.println("Forza Stabile!");
                forzaPotere = "Forza Stabile";
            } else {
                System.out.println("Forza Selvaggia!");
                forzaPotere = "Forza Selvaggia";
            }
        } else {
            System.out.println("Non hai poteri nascosti.");
        }

        System.out.print("\nInserisci un numero da 1 a 7 per scoprire il tuo superpotere del giorno: ");
        int giorno = input.nextInt();

        switch (giorno){
            case 1:
                superpotereGiorno = "Invisibilita'";
                break;
            case 2:
                superpotereGiorno = "Super Velocita'";
                break;
            case 3:
                superpotereGiorno = "Forza Incredibile";
                break;
            case 4:
                superpotereGiorno = "Telepatia";
                break;
            case 5:
                superpotereGiorno = "Volo";
                break;
            case 6:
                superpotereGiorno = "Visione a Raggi X";
                break;
            case 7:
                superpotereGiorno = "Controllo del Tempo";
                break;
            default:
                superpotereGiorno = "Super Potere Sconosciuto";
        }
        System.out.println("Il superpotere di oggi e': " +superpotereGiorno);

        System.out.println("\nRisultato Finale: ");
        System.out.print("Hai una " +forzaPotere+", con un superpotere speciale di "+superpotereGiorno+" e poteri nascosti");

    }
}
