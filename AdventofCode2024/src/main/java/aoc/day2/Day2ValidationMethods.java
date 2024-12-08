package aoc.day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day2ValidationMethods {

    public static List<List<Integer>> day2processInput(String fileName) {
        try (Stream<String> linesStream = Files.lines(Paths.get(fileName))) {
            List<List<Integer>> linesList = linesStream
                    .map(line -> line.trim())
                    .map(line -> List.of(line.split(" ")))
                    .map(numbers -> numbers.stream()
                            .map(Integer::parseInt)
                            .collect(Collectors.toList()))
                    .collect(Collectors.toList());

            linesList.forEach(System.out::println);
            return linesList;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Day2ValidationResult countValidLines(List<List<Integer>> inputList) {
        int validRows = 0;
        List<List<Integer>> invalidRows = new ArrayList<>();

        for (int rowIndex = 0; rowIndex < inputList.size(); rowIndex++) {
            List<Integer> oneLine = inputList.get(rowIndex);
            if (isLineValid(oneLine)) {
                validRows++;
            }
            else {
                invalidRows.add(oneLine);
            }
        }
        System.out.println("Valid rows count is " + validRows);
        return new Day2ValidationResult(validRows, invalidRows);
    }

    private static boolean isLineValid(List<Integer> oneLine) {
        if (!hasValidDifferences(oneLine)) {
            return false;
        }
        return isAscending(oneLine) || isDescending(oneLine);
    }

    private static boolean hasValidDifferences(List<Integer> oneLine) {
        for (int index = 0; index < oneLine.size() - 1; index++) {
            int currentNumber = oneLine.get(index);
            int nextNumber = oneLine.get(index + 1);
            int difference = Math.abs(currentNumber - nextNumber);

            if (difference < 1 || difference > 3) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAscending(List<Integer> oneLine) {
        for (int index = 0; index < oneLine.size() - 1; index++) {
            if (oneLine.get(index) >= oneLine.get(index + 1)) {
                return false;
            }
            //else nedělej nic a jdi na další dvojici čísel
        }
        //když takto projdeš všechny dvojice a dostaneš se až sem, tak vrať true
        return true;
    }

    private static boolean isDescending(List<Integer> oneLine) {
        for (int index = 0; index < oneLine.size() - 1; index++) {
            if (oneLine.get(index) <= oneLine.get(index + 1)) {
                return false;
            }
        }
        return true;
    }

    public static int processInvalidRows(List<List<Integer>> invalidRows) {
        int newValidRows = 0;

        for (List<Integer> row : invalidRows) {

            for(int index = 0; index < row.size(); index++) {
                List<Integer> modifiedRow = new ArrayList<>(row);
                modifiedRow.remove(index);
                if (isLineValid(modifiedRow)) {
                    newValidRows++;
                    break;
                }
            }
        }
        System.out.println("Newly fixed rows sum: " + newValidRows);
        return newValidRows;
    }

    public static void countTotalValidRows(List<List<Integer>> inputList) {
        Day2ValidationResult validationResult = countValidLines(inputList);
        System.out.println("Valid rows count, 1st part: " + validationResult.getValidRows());
        List<List<Integer>> invalidRows = validationResult.getInvalidRows();
        int newValidRows = processInvalidRows(invalidRows);
        System.out.println("Fixed rows count, 2nd part: " + newValidRows);
        int completeValidRows = newValidRows + validationResult.getValidRows();
        System.out.println("Valid rows count, 2nd part: " + completeValidRows);
    }
}
