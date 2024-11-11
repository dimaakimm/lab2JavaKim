import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название файла. Он должен находить в папке Input. Допустимый формат - '.txt':");
        String input = in.nextLine();
        String filename = input + ".txt";
        String pathToFile = "./Input/" + filename;
        System.out.println("Файл для записи результата: Output/" + input + "Output.txt");
        String outputFile = input + "Output.txt";
        String outputFilePath = "./Output/" + outputFile;
        int[] lettersCounter;
        try {
            FileManager.checkIfFileExists(pathToFile);
            lettersCounter = FileManager.readInput(pathToFile);
            FileManager.createOutputFile(outputFilePath);
            FileManager.writeOutput(outputFilePath, lettersCounter);
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }








    }
}