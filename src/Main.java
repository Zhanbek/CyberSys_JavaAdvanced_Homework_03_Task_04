import java.io.*;

public class Main {
    private static final String SAMPLE_FILE_PATH = "src/Files/SampleCodeFile/SampleCode.java";
    private static final String NEW_FILE_PATH = "src/Files/NewFile/SampleCode.txt";
    private static final String MY_COMMENT = "Мій коментар";

    public static void main(String[] args) {


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(SAMPLE_FILE_PATH)));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(NEW_FILE_PATH)))) {
            // 1. Створіть у пакеті текстовий файл NEW_FILE_PATH і клас
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line +  System.lineSeparator());
            }
            // 2. Внесіть у файл NEW_FILE_PATH якийсь текст.
            bufferedWriter.append("// ").append(MY_COMMENT.concat(System.lineSeparator()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 3. Виведіть на екран вміст нового файлу.
        System.out.println();
        System.out.println(String.format("Вміст нового файлу %s - копії файлу %s, доповненої текстом коментаря \"%s\"",
                                         NEW_FILE_PATH,
                                         SAMPLE_FILE_PATH,
                                         MY_COMMENT));
        System.out.println();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(NEW_FILE_PATH))){
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
