import java.util.Scanner;

public class primenumber {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = scanner.nextInt();

        boolean isPrime = checkPrime(num);
        if (isPrime){
            System.out.println(num + " is a prime number.");
        }else{
            System.out.println(num + " is a not prime number.");
        }
    }

    public static boolean checkPrime(int num){
        if (num < 1){
            return false;
        }else{
            for (int i = 2; i <= Math.sqrt(num); i++){
                if (num % i == 0){
                    return false;
                }
            }
        }
        return true;
    }
}
