package base;

import javax.sound.midi.SysexMessage;

public class CostruttoSwitch {

    public static void main(String[] args){

        int num = 2;

        switch(num) { //il parametro num viene comparato con ognuno dei case presenti fino a quando non ne trova uno che combaci
            case 1:
                System.out.println("Il numero e' 1!");
                break;
            case 2:
                System.out.println("Il numero e' 2!");
                break;
            case 3:
                System.out.println("Il numero e' 3!");
                break;
            default:
                System.out.println("Il numero non e' presente nella selezione!");
        }

        String str = "Hello!"; //il compilatore vuole sempre che le variabili vengano inizializzate prima di essere ysate
        System.out.println(str);
    }
}
