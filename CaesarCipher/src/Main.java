import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введіть текст для шифрування: ");
        String plaintext = input.nextLine();
        System.out.print("Введіть значення зсуву: ");
        int shift = input.nextInt();

        String ciphertext = encrypt(plaintext, shift);
        System.out.println("Зашифрований текст: " + ciphertext);

        String decryptedText = decrypt(ciphertext, shift);
        System.out.println("Розшифрований текст: " + decryptedText);
    }

    public static String encrypt(String plaintext, int shift) {
        String ciphertext = "";
        for (int i = 0; i < plaintext.length(); i++) {
            char c = plaintext.charAt(i);
            if (Character.isLetter(c)) {
                c = (char) (c + shift);
                if (Character.isLowerCase(plaintext.charAt(i)) && c > 'z') {
                    c = (char) (c - 26);
                } else if (Character.isUpperCase(plaintext.charAt(i)) && c > 'Z') {
                    c = (char) (c - 26);
                }
            }
            ciphertext += c;
        }
        return ciphertext;
    }

    public static String decrypt(String ciphertext, int shift) {
        String plaintext = "";
        for (int i = 0; i < ciphertext.length(); i++) {
            char c = ciphertext.charAt(i);
            if (Character.isLetter(c)) {
                c = (char) (c - shift);
                if (Character.isLowerCase(ciphertext.charAt(i)) && c < 'a') {
                    c = (char) (c + 26);
                } else if (Character.isUpperCase(ciphertext.charAt(i)) && c < 'A') {
                    c = (char) (c + 26);
                }
            }
            plaintext += c;
        }
        return plaintext;
    }
}
