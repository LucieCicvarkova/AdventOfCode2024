package aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputProcessing {
    public static List<String> readInputToListString(String fileName) {
        try (Stream<String> linesStream = Files.lines(Paths.get(fileName))) {
            List<String> linesList = linesStream.collect(Collectors.toList());
            linesList.forEach(System.out::println);
            return linesList;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

