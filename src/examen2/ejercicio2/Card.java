package examen2.ejercicio2;

public class Card implements IMoney {
    String number;
    private double balance;
    private double credit;

    public Card(String number, double balance, double credit) {
        this.number = number;
        this.balance = balance;
        this.credit = credit;
    }

    public double value() {
        return balance + credit;
    }
}
