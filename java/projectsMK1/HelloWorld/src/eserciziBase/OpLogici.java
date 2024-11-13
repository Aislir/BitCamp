package eserciziBase;
import java.util.Scanner;

public class OpLogici {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Inserire 2 numeri interi: ");
        int num1 = input.nextInt();
        int num2 = input.nextInt();

        if (num1 > 0 && num2 > 0){
            System.out.println("Entrambi i numeri inseriti sono maggiori di 0");
        }
    }
}
