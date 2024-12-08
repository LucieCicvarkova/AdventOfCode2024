package aoc.day3;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 {

    public static int getSumOfMultiplications(String inputPath) {
        try {
            String input = Files.readString(Paths.get(inputPath), StandardCharsets.UTF_8);

            // Regex for `mul(num1,num2)`
            String regex = "mul\\((\\d+),(\\d+)\\)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            int sum = matcher.results()
                    .map(matchResult -> {
                        int num1 = Integer.parseInt(matchResult.group(1));
                        int num2 = Integer.parseInt(matchResult.group(2));
                        return num1 * num2;
                    })
                    .reduce(0, Integer::sum);

            System.out.println("Total sum, part 1: " + sum);
            return sum;
        } catch (IOException e) {
            System.out.println("Reading file error: " + e.getMessage());
            return -1;
        }
    }

    public static int getSumOfMultiplicationsPart2(String inputPath) {
        try {
            String input = Files.readString(Paths.get(inputPath), StandardCharsets.UTF_8);

            // Regex for `mul(num1,num2)` OR 'do()' OR 'don´t()'
            String regex = "mul\\((\\d+),(\\d+)\\)|do\\(\\)|don't\\(\\)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            boolean countingEnabled = true;
            int sum = 0;

            while (matcher.find()) {
                String matchedText = matcher.group();

                if ("do()".equals(matchedText)) {
                    countingEnabled = true;

                } else if ("don't()".equals(matchedText)) {
                    countingEnabled = false;

                } else if (matchedText.startsWith("mul(") && countingEnabled) {
                    int num1 = Integer.parseInt(matcher.group(1));
                    int num2 = Integer.parseInt(matcher.group(2));
                    sum += num1 * num2;
                }
            }
            System.out.println("Total sum, part 2: " + sum);
            return sum;
        } catch (IOException e) {
            System.out.println("Reading file error: " + e.getMessage());
            return -1;
        }
    }


}


