import java.io.*;
import java.nio.file.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        String inputFile = "input.txt";   // Путь к входному .txt файлу
        String outputFile = "inf.svc"; // Путь к выходному .svc файлу

        try {
            // Чтение всего содержимого файла в строку
            String textContent = Files.lines(Paths.get(inputFile)).collect(Collectors.joining("\n"));

            // Вычисление статистики
            long totalChars = textContent.chars().count();
            long totalCharsNoSpaces = textContent.chars().filter(ch -> !Character.isWhitespace(ch)).count();
            long totalWords = textContent.isBlank() ? 0 : textContent.trim().split("\\s+").length;

            // Форматирование результата
            String result = String.format("Анализ текста:\n"
                    + "Всего символов: %d\n"
                    + "Символов без пробелов: %d\n"
                    + "Всего слов: %d\n", totalChars, totalCharsNoSpaces, totalWords);

            // Вывод результата в консоль
            System.out.println(result);
            // Запись результата в файл .svc
            Files.writeString(Paths.get(outputFile), result);
            System.out.println("Результат анализа успешно сохранён в файл: " + outputFile);
        } catch (IOException e) {
            System.err.println("Исключение при работе с файлами: " + e.getMessage());
        }
    }
}
