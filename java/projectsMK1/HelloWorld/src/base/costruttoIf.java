package base;

public class costruttoIf {

    public static void main(String[] args){

        int a = 10;
        int b = 5;
        int c = a + b;
        boolean x = true;
        boolean y = false;

        if (c > 15 && x){
            System.out.println("La somma di a e b e' maggiore di 15 e x e' true");
        } else if(c <= 15 || y){
            System.out.println("La somma di a e b e' minore o uguale a 15 o y e' true");
        } else {
            System.out.println("Nessuna delle condizioni precedenti e' stata soddisfatta");
        }
    }
}
