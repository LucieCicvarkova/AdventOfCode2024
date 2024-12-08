package aoc;

import java.util.Map;


public class Main {
    public static void main(String[] args) {

        runTask("day4");
    }

    public static void runTask(String key) {

        Map<String, String> inputFiles = Map.of(
                "day1", "src/main/java/aoc/day1/Day1_test_input.txt",
                "day2", "src/main/java/aoc/day2/Day2_test_input.txt",
                "day3", "src/main/java/aoc/day3/Day3_test_input.txt",
                "day4", "src/main/java/aoc/day4/Day4_test_input.txt"
        );

        Task task = TaskFactory.getTask(key);
        task.execute(inputFiles.get(key));
    }
}
