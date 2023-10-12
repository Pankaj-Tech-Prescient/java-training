import java.util.Scanner;

public class word_count {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a text string: ");
        String text = scanner.nextLine();

        String[] words = text.split("[\\s\\p{Punct}]+");
        System.out.println("Number of words in the text: " + words.length);
    }
}
