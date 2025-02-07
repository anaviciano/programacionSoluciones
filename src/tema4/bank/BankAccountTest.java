package tema4.bank;

import java.util.Scanner;

public class BankAccountTest {
    public static void main(String[] args) {
        BankAccountTest test = new BankAccountTest();
        Scanner scanner = new Scanner(System.in);
        Person[] people = new Person[10];
        int currentPerson = 0;
        int option = 0;
        while (option != 8) {
            option = readOptionMenu(scanner);
            switch (option) {
                case 1:
                    people[currentPerson] = readPerson(scanner);
                    currentPerson++;
                    break;
                case 2:
                    readAccount(scanner, people);
                    break;
                case 3:
                    System.out.print("DNI: ");
                    String id = scanner.nextLine();
                    printPerson(id, people);
                    break;
                case 4:
                    receivePayroll(scanner, people);
                    break;
                case 5:
                    doPayment(scanner, people);
                    break;
                case 6:
                    doTransfer(scanner, people);
                    break;
                case 7:
                    printDefaulters(scanner, people);
                    break;
            }
        }
    }

    public static int readOptionMenu(Scanner scanner) {
        int option;
        do {
            System.out.println("1. Crear persona");
            System.out.println("2. Crear cuenta");
            System.out.println("3. Mostrar datos de persona");
            System.out.println("4. Recibir nómina mensual");
            System.out.println("5. Hacer un pago");
            System.out.println("6. Realizar transferencia");
            System.out.println("7. Imprimir listado de morosos");
            System.out.println("8. Salir");
            System.out.print("Opción: ");
            option = scanner.nextInt();
            scanner.nextLine();
        } while (option < 1 || option > 8);
        return option;
    }

    public static Person readPerson(Scanner scanner) {
        System.out.println("Leyendo nueva persona");
        System.out.print("DNI: ");
        String id = scanner.nextLine();
        return new Person(id);
    }
    public static Person findPerson(String id, Person[] people) {
        for (Person person : people) {
            if (person != null && person.getId().equals(id)) {
                return person;
            }
        }
        return null;
    }
    public static void printPerson(String id, Person[] people) {
        Person person = findPerson(id, people);
        if (person != null) {
            System.out.println(person);
        } else {
            System.out.println("Persona no encontrada");
        }
    }
    public static void readAccount(Scanner scanner, Person[] people) {
        System.out.println("Leyendo nueva cuenta");
        System.out.print("Número de cuenta: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Saldo inicial: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Propietario: ");
        String id = scanner.nextLine();
        Person person = findPerson(id, people);
        if (person != null) {
            person.addAccount(new BankAccount(accountNumber, balance));
        } else {
            System.out.println("Persona no encontrada");
        }
    }
    public static BankAccount findAccount(String id, String accountNumber, Person[] people) {
        Person person = findPerson(id, people);
        if (person != null) {
            for (BankAccount account : person.getAccounts()) {
                if (account != null && account.getAccountNumber().equals(accountNumber)) {
                    return account;
                }
            }
        }
        return null;
    }

    public static BankAccount findAccount(String accountNumber, Person[] people) {
        for (Person person : people) {
            if (person != null) {
                for (BankAccount account : person.getAccounts()) {
                    if (account != null && account.getAccountNumber().equals(accountNumber)) {
                        return account;
                    }
                }
            }
        }
        return null;
    }

    public static void receivePayroll(Scanner scanner, Person[] people) {
        System.out.println("Recibiendo nómina");
        System.out.print("Número de cuenta: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Cantidad: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Propietario: ");
        String id = scanner.nextLine();
        BankAccount account = findAccount(id, accountNumber, people);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Cuenta no encontrada");
        }
    }

    public static void doPayment(Scanner scanner, Person[] people) {
        System.out.println("Realizando pago");
        System.out.print("Número de cuenta: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Cantidad: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Propietario: ");
        String id = scanner.nextLine();
        BankAccount account = findAccount(id, accountNumber, people);
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("Cuenta no encontrada");
        }
    }

    public static void doTransfer(Scanner scanner, Person[] people) {
        System.out.println("Realizando transferencia");
        System.out.print("Número de cuenta origen: ");
        String accountNumber1 = scanner.nextLine();
        System.out.print("Número de cuenta destino: ");
        String accountNumber2 = scanner.nextLine();
        System.out.print("Cantidad: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        BankAccount account1 = findAccount(accountNumber1, people);
        BankAccount account2 = findAccount(accountNumber2, people);
        if (account1 != null && account2 != null) {
            account1.transfer(account2, amount);
        } else {
            System.out.println("Cuenta no encontrada");
        }
    }
    public static void printDefaulters(Scanner scanner, Person[] people) {
        System.out.println("Listado de morosos");
        for (Person person : people) {
            if (person != null && person.isDefaulter()) {
                System.out.println(person);
            }
        }
    }
}
