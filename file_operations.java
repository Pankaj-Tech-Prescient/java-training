import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class file_operations {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the input file: ");
        String inputFile = scanner.nextLine();

        System.out.println("Enter the name of the output file: ");
        String outputFile = scanner.nextLine();

        try {
            copyFile(inputFile, outputFile);
            System.out.println("File copy completed successfully");
        } catch (IOException e){
            System.err.println("Error : " + e.getMessage());
        }
    }

    public static void copyFile(String inputFile, String OutputFile) throws IOException{
        try(BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(OutputFile))) {
            String line;
            while ((line = reader.readLine()) != null){
                writer.write(line);
                writer.newLine();
            }
        }
    }
}