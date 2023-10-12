import java.util.Scanner;

public class palindrome {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a String: ");
        String text = scanner.nextLine();

        boolean isPalindrome = checkPalindrome(text);
        if (isPalindrome){
            System.out.println(text + " is Palindrome.");
        }else{
            System.out.println(text + " is not Palindrome.");
        }
    }

    public static boolean checkPalindrome(String text){
        text = text.replaceAll("\\s", "").toLowerCase();
        int left = 0;
        int right = text.length() - 1;

        while (left < right){
            if (text.charAt(left) != text.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
