import java.util.Scanner;


public class MatrixOperations {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Matric 1: ");
        int[][] matrix1 = inputMatrix(scanner);

        System.out.println("Matrix 2: ");
        int[][] matrix2 = inputMatrix(scanner);

        System.out.println("Matrix 1: ");
        printMatrix(matrix1);

        System.out.println("Matrix 2: ");
        printMatrix(matrix2);

        System.out.println("Matrix1 + Matrix2");
        int[][] sum = addMatrices(matrix1, matrix2);
        printMatrix(sum);

        System.out.println("Matrix1 - Matrix2");
        int[][] difference = subtractMatrices(matrix1, matrix2);
        printMatrix(difference);

        System.out.println("Matrix * Matrix2");
        int[][] multiply = multiplyMatrices(matrix1, matrix2);
        printMatrix(multiply);
    }

    public static int[][] inputMatrix(Scanner scanner){
        System.out.println("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of columns: ");
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];

        System.out.println("Enter matrix elements row by row ");

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2){
        int rows = matrix1.length;
        int cols = matrix1[0].length;

        int[][] sum = new int[rows][cols];

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                sum[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return sum;
    }

    public static int[][] subtractMatrices(int[][] matrix1, int[][] matrix2){
        int rows = matrix1.length;
        int cols = matrix1[0].length;

        int[][] difference = new int[rows][cols];

        for (int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                difference[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return difference;
    }

    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2){
        int rows = matrix1.length;
        int cols = matrix1[0].length;

        int[][] multiplication = new int[rows][cols];

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                multiplication[i][j] = matrix1[i][j] * matrix2[i][j];
            }
        }
        return multiplication;
    }
}