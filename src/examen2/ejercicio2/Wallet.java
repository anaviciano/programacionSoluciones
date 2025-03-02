package examen2.ejercicio2;

public class Wallet {
    private IMoney[] money = new IMoney[10];
    private int count;

    public Wallet() {
        money = new IMoney[10];
        count = 0;
    }

    public void add(IMoney m) {
        if (count < money.length) {
            money[count] = m;
            count++;
        }
    }

    public double value() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += money[i].value();
        }
        return total;
    }
    public boolean canPay(double amount) {
        return value() >= amount;
    }
}
