package examen2.ejercicio2;

import examen2.ejercicio2.Bill;
import examen2.ejercicio2.Card;
import examen2.ejercicio2.Wallet;

public class SlotMachine {
    public static void main(String[] args) {
        Wallet wallet = new Wallet();
        wallet.add(new Bill(5));
        wallet.add(new Bill(20));
        wallet.add(new Bill(50));
        wallet.add(new Card("1234", 100, 50));
        wallet.add(new Card("5678", 1000, 500));

        System.out.println("Total: " + wallet.value() + " €");
    }
}
