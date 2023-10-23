import java.util.Scanner;

public class studentGrade {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        String[] studentNames = new String[numStudents];
        double[] studentScores = new double[numStudents];

        for (int i = 0; i < numStudents; i++){
            scanner.nextLine();
            System.out.println("Enter the name of student: ");
            studentNames[i] = scanner.nextLine();
            System.out.println("Enter the score for " + studentNames[i] + ": ");
            studentScores[i] = scanner.nextDouble();
        }

        for (int i = 0; i < numStudents; i++){
            char grade = calculateGrade(studentScores[i]);
            System.out.println(studentNames[i] + " scored " + studentScores[i] + " and receieved a grade of " + grade);
        }
    }

    public static char calculateGrade(double score){
        if (score >= 90){
            return 'A';
        } else if (score >= 80) {
            return 'B';
        } else if (score >= 70) {
            return 'C';
        } else if (score >= 60) {
            return 'D';
        }else {
            return 'F';
        }
    }
}
