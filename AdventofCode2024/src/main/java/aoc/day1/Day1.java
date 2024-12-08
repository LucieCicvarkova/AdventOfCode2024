package aoc.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day1 {

    public static List<int[]> processInput(String fileName) {
        try (Stream<String> linesStream = Files.lines(Paths.get(fileName))) {
            List<int[]> pairs = linesStream
                    .map(line -> line.split("\\s+"))
                    .filter(parts -> parts.length == 2)
                    .map(parts -> new int[]{Integer.parseInt(parts[0]), Integer.parseInt(parts[1])})
                    .collect(Collectors.toList());
            return pairs;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void getDifferencesSum(List<int[]> processedInput) {
        List<Integer> firstColumn = processedInput.stream()
                .map(pair -> pair[0])
                .sorted()
                .collect(Collectors.toList());

        List<Integer> secondColumn = processedInput.stream()
                .map(pair -> pair[1])
                .sorted()
                .collect(Collectors.toList());

        int sumOfDifferences = 0;
        for (int i = 0; i < firstColumn.size(); i++) {
            if (firstColumn.get(i) > secondColumn.get(i)) {
                int difference = firstColumn.get(i) - secondColumn.get(i);
                sumOfDifferences += difference;
            } else {
                int difference = secondColumn.get(i) - firstColumn.get(i);
                ;
                sumOfDifferences += difference;
            }
        }
        System.out.println("Differences sum: " + sumOfDifferences);
    }

    public static void getFrequenciesSum(List<int[]> processedInput) {
        List<Integer> firstColumn = processedInput.stream()
                .map(pair -> pair[0])
                .collect(Collectors.toList());

        List<Integer> secondColumn = processedInput.stream()
                .map(pair -> pair[1])
                .collect(Collectors.toList());

        Map<Integer, Long> frequencyMap = secondColumn.stream()
                .collect(Collectors.groupingBy(
                        number -> number,
                        Collectors.counting()
                ));

        long totalSum = firstColumn.stream()
                .mapToLong(number -> {
                    long frequency = frequencyMap.getOrDefault(number, 0L);
                    return number * frequency;
                })
                .sum();

        System.out.println("Frequencies sum: " + totalSum);
    }
}
