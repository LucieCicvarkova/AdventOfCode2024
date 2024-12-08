package aoc.day3;

import aoc.Task;
import static aoc.day3.Day3.getSumOfMultiplications;
import static aoc.day3.Day3.getSumOfMultiplicationsPart2;

public class Day3Task implements Task {
    @Override
    public void execute(String inputFilePath) {
        getSumOfMultiplications(inputFilePath);
        getSumOfMultiplicationsPart2(inputFilePath);
    }
}
