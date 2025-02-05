package tema3;

public class CaesarCipher {

    public static String encrypt(String string) {
        string = string.toUpperCase();
        String encrypted = "";
        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            if (character >= 'A' && character <= 'Z') {
                character += 1;
                if (character > 'Z') {
                    character -= 26;
                }
            }
            encrypted += character;
        }
        return encrypted;
    }

    public static String decrypt(String string) {
        string = string.toUpperCase();
        String decrypted = "";
        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            if (character >= 'A' && character <= 'Z') {
                character -= 1;
                if (character < 'A') {
                    character += 26;
                }
            }
            decrypted += character;
        }
        return decrypted;
    }

    public static void main(String[] args) {
        String string = "Hello WorldZ!";
        String encrypted = encrypt(string);
        System.out.println(encrypted);
        String decrypted = decrypt(encrypted);
        System.out.println(decrypted);
    }
}
