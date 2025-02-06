package tema4.bank;

public class Person {
    private String id;
    private BankAccount[] accounts = new BankAccount[3];
    private int currentAccount = 0;

    public Person(String id) {
        this.id = id;
    }

    public void addAccount(BankAccount account) {
        if (currentAccount < accounts.length) {
            accounts[currentAccount] = account;
            currentAccount++;
        }
    }
    public boolean isDefaulter() {
        for (int i = 0; i < currentAccount; i++) {
            if (accounts[i].getBalance() < 0) {
                return true;
            }
        }
        return false;
    }

    public String getId() {
        return id;
    }

    public BankAccount[] getAccounts() {
        return accounts;
    }
    public String toString() {
        String result = "DNI: %s\n".formatted(id);
        for (int i = 0; i < currentAccount; i++) {
            result += "\t%s\n".formatted(accounts[i].toString());
        }
        return result;
    }
}