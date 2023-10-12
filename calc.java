import java.util.Scanner;

public class calc {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the command line Calc");

        System.out.println("Enter the first Number: ");
        int n1 = scanner.nextInt();

        System.out.println("Enter the second Number: ");
        int n2 = scanner.nextInt();

        System.out.println("Enter the operator (+, -, *, .): ");
        char operator = scanner.next().charAt(0);

        int res;

        switch (operator){
            case '+':
                res = n1 + n2;
                System.out.println("Result: " + res);
                break;
            case '-':
                res = n1 - n2;
                System.out.println("Result: " + res);
                break;
            case '*':
                res = n1 * n2;
                System.out.println("Result: " + res);
                break;
            case '/':
                res = n1 / n2;
                System.out.println("Result: " + res);
                break;
            default:
                System.out.println("Invalid Input !!");
        }
    }
}