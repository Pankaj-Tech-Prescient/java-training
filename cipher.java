import java.util.Scanner;

public class cipher {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Encrypt/Decrypt");
            System.out.println("1. Encrypt");
            System.out.println("2. Decrypt");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 3){
                System.out.println("Exiting the program.");
                break;
            }

            System.out.println("Enter the text: ");
            String text = scanner.nextLine();

            System.out.println("Enter shift value: ");
            int shift = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1){
                String encryptedText = encrypt(text, shift);
                System.out.println("Encrypted text: " + encryptedText);
            } else if (choice == 2) {
                String decryptedText = decrypt(text, shift);
                System.out.println("Decrypted text: " + decryptedText);
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    private static String encrypt(String text, int shift){
        StringBuilder encryptedText = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                char encryptedChar = (char) ((c - base + shift) % 26 + base);
                encryptedText.append(encryptedChar);
            } else {
                encryptedText.append(c);
            }
        }
        return encryptedText.toString();
    }

    private static String decrypt(String text, int shift){
        return encrypt(text, 26 - shift);
    }
}
