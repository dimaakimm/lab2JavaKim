import java.io.*;

public class FileManager {
    private static final int TOTAL_LETTERS = 52;

    public static void checkIfFileExists(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found. Please make sure " + file.getName() + " is in /InputFiles");
        } else if (!file.canRead()) {
            throw new IOException("Cannot read the file: " + file.getName());
        }
    }
    public static void createOutputFile(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        } else if (!file.canWrite()) {
            throw new IOException("Cannot write to file: " + file.getName());
        }
    }
    public static int[] readInput(String path_to_file) {
        StringBuilder result = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(path_to_file))) {
            String line;
            while ((line = br.readLine()) != null) {
                result.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
        return countLetters(result.toString());
    }

    private static int[] countLetters(String str) {
        int[] lettersCounter = new int[TOTAL_LETTERS];
        for (char c : str.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                lettersCounter[c - 'A']++;
            } else if (c >= 'a' && c <= 'z') {
                lettersCounter[26 + c - 'a']++;
            }
        }
        return lettersCounter;
    }
    public static void writeOutput(String filename, int[] lettersCounter) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < lettersCounter.length; i++) {
                if (lettersCounter[i] > 0) {
                    char letter = (char)(i < 26  ? 'A' + i : 'a' + (i - 26));
                    bw.write(letter + ": " + lettersCounter[i]);
                    bw.newLine();
                }

            }
        } catch (IOException e) {
            System.out.println("Ошибка в записи в файл: " + e.getMessage());
        }
        System.out.println("Рекзультат записан в: " + filename);
    }
}
