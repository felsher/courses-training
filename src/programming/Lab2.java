package programming;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Lab2 {

    private static final String filePath = "/Users/felsher/IdeaProjects/test/resources/dates.txt";

    public static void main(String[] args) throws Exception {

        List<String> dates = readDatesFromFile(filePath);

        System.out.println("All dates from text file:");
        printList(dates);

        String result = findEarliestSpringDate(dates);

        if (result != null) {
            System.out.println("The earliest spring date is: " + result);
        } else {
            System.out.println();
        }
    }

    // раннюю дату весны так и не стал находить,
    // метод просто выводит на экран все весенние даты
    private static String findEarliestSpringDate(List<String> dates) {
        AtomicReference<String> result = new AtomicReference<>("");

        List<String> springDates = dates.stream()
                .filter(date -> {
                    String[] dateParts = date.split("/");
                    String monthPart = dateParts[1];
                    Integer monthNumber = Integer.valueOf(monthPart);
                    return monthNumber > 2 && monthNumber < 6;
                })
                .collect(Collectors.toList());

        System.out.println("All spring dates:");
        printList(springDates);

        return result.get();
    }

    private static void printList(List<String> dates) {
        dates.forEach(System.out::println);
    }

    private static List<String> readDatesFromFile(String filePath) throws Exception {
        Path path = Paths.get(filePath);
        return Files.readAllLines(path, StandardCharsets.UTF_8);
    }
}
