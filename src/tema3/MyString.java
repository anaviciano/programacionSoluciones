package tema3;

public class MyString {

    public static String invertedToUppercase(String string) {
        String inverted = "";
        for (int i = string.length() - 1; i >= 0; i--) {
            inverted += string.charAt(i);
        }
        return inverted.toUpperCase();
    }

    public static int countVowels(String string) {
        int vowels = 0;
        string = string.toLowerCase();
        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            if (character == 'a' || character == 'e' || character == 'i' ||
                    character == 'o' || character == 'u') {
                vowels++;
            }
        }
        return vowels;
    }

    public static String longestWord(String string) {
        String[] words = string.split(" ");
        String longest = "";
        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }

    public static int repeatedString(String string, String substring) {
        int count = 0;
        int index = 0;
        while (index != -1) {
            index = string.indexOf(substring, index);
            if (index != -1) {
                count++;
                index += substring.length();
            }
        }
        return count;
    }

    public static int countWords(String string) {
        int count = 0;
        boolean isWord = false;
        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            if (character != ' ' && !isWord) {
                isWord = true;
                count++;
            } else if (character == ' ') {
                isWord = false;
            }
        }
        return count;
    }

    public static String formatPhone(String phoneNumber) {
        String formatedPhoneNumber = "";
        if (phoneNumber.length() == 11) {
            formatedPhoneNumber = String.format("(%s)-%s-%s",
                    phoneNumber.substring(0, 2),
                    phoneNumber.substring(2, 5),
                    phoneNumber.substring(5));
        }
        return formatedPhoneNumber;
    }

    public static void vowelHistogram(String string) {
        int[] histogram = new int[5];
        string = string.toLowerCase();
        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            if (character == 'a') {
                histogram[0]++;
            } else if (character == 'e') {
                histogram[1]++;
            } else if (character == 'i') {
                histogram[2]++;
            } else if (character == 'o') {
                histogram[3]++;
            } else if (character == 'u') {
                histogram[4]++;
            }
        }
        System.out.printf("a: (%d) %s\r\n", histogram[0], "*".repeat(histogram[0]));
        System.out.printf("e: (%d) %s\r\n", histogram[1], "*".repeat(histogram[1]));
        System.out.printf("i: (%d) %s\r\n", histogram[2], "*".repeat(histogram[2]));
        System.out.printf("o: (%d) %s\r\n", histogram[3], "*".repeat(histogram[3]));
        System.out.printf("u: (%d) %s\r\n", histogram[4], "*".repeat(histogram[4]));
    }

    public static void main(String[] args) {
        String string = "Hello World!";
        System.out.println("Original: " + string);
        System.out.println("Inverted:  " + invertedToUppercase(string));
        System.out.println("Vowels: " + countVowels(string));
        System.out.println("Longest Word: " + longestWord(string));
        System.out.println("Repeated Substring 'll': " + repeatedString(string, "ll"));
        System.out.println("Word Count: " + countWords(string));
        System.out.println("Vowel Histogram:");
        vowelHistogram(string);
        System.out.println("Phone Format '12345678901': " + formatPhone("12345678901"));
    }
}
