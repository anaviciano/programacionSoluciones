package tema3;

public class Utils {
    public static double miles2kilometers(double miles) {
        return miles * 1.60934;
    }

    public static double getFixedPrice(double price) {
        return Math.round(price * 100) / 100.0;
    }

    public static double getTaxes(double price, double taxRate) {
        return Math.round(getFixedPrice(price) * taxRate) / 100.0;
    }

    public static double getNetPrice(double price, double taxRate) {
        double fixedPrice = getFixedPrice(price);
        return fixedPrice + getTaxes(fixedPrice, taxRate);
    }

    public static int getCoins(double euros) {
        int cents = (int) Math.round(euros * 1000) / 10;
        int coins = 0;

        while (cents > 0) {
            if (cents >= 200) {
                coins += 10000000;
                cents -= 200;
            } else if (cents >= 100) {
                coins += 1000000;
                cents -= 100;
            } else if (cents >= 50) {
                coins += 100000;
                cents -= 50;
            } else if (cents >= 20) {
                coins += 10000;
                cents -= 20;
            } else if (cents >= 10) {
                coins += 1000;
                cents -= 5;
            } else if (cents >= 5) {
                coins += 100;
                cents -= 5;
            } else if (cents >= 2) {
                coins += 10;
                cents -= 2;
            } else {
                coins += 1;
                cents -= 1;
            }
        }

        return coins;
    }

    public static double calculateIRPF(double salary) {
        double step1 = 12450;
        double step2 = 20199;
        double step3 = 35199;
        double step4 = 59999;

        double type1 = 0.19;
        double type2 = 0.24;
        double type3 = 0.30;
        double type4 = 0.37;
        double type5 = 0.47;

        int step = 5;
        if (salary <= step1) {
            step = 1;
        } else if (salary <= step2) {
            step = 2;
        } else if (salary <= step3) {
            step = 3;
        } else if (salary <= step4) {
            step = 4;
        }

        double irpf = 0;
        switch (step) {
            case 1:
                irpf = salary * type1;
                break;
            case 2:
                irpf = step1 * type1 + (salary - step1) * type2;
                break;
            case 3:
                irpf = step1 * type1 + step2 * type2 + (salary - step2 - step1) * type3;
                break;
            case 4:
                irpf = step1 * type1 + step2 * type2 + step3 * type3 + (salary - step3 - step2 - step1) * type4;
                break;
            case 5:
                irpf = step1 * type1 + step2 * type2 + step3 * type3 + step4 * type4 + (salary - step4 - step3 - step2 - step1) * type5;
                break;
        }

        return irpf;
    }

    public static char getNIF(int dni) {
        int remainder = dni % 23;
        char letter = ' ';

        switch (remainder) {
            case 0:
                letter = 'T';
                break;
            case 1:
                letter = 'R';
                break;
            case 2:
                letter = 'W';
                break;
            case 3:
                letter = 'A';
                break;
            case 4:
                letter = 'G';
                break;
            case 5:
                letter = 'M';
                break;
            case 6:
                letter = 'Y';
                break;
            case 7:
                letter = 'F';
                break;
            case 8:
                letter = 'P';
                break;
            case 9:
                letter = 'D';
                break;
            case 10:
                letter = 'X';
                break;
            case 11:
                letter = 'B';
                break;
            case 12:
                letter = 'N';
                break;
            case 13:
                letter = 'J';
                break;
            case 14:
                letter = 'Z';
                break;
            case 15:
                letter = 'S';
                break;
            case 16:
                letter = 'Q';
                break;
            case 17:
                letter = 'V';
                break;
            case 18:
                letter = 'H';
                break;
            case 19:
                letter = 'L';
                break;
            case 20:
                letter = 'C';
                break;
            case 21:
                letter = 'K';
                break;
            case 22:
                letter = 'E';
                break;
        }
        return letter;
    }

    public static boolean isValidNIF(int dni, char letter) {
        return getNIF(dni) == Character.toUpperCase(letter);
    }
}
