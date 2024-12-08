package aoc.day4;

import aoc.Task;
import static aoc.day4.Day4.countWordOccurrence;
import static aoc.day4.Day4.processInputDay4;

public class Day4Task implements Task {
    @Override
    public void execute(String inputFilePath) {
        var input = processInputDay4(inputFilePath);
        countWordOccurrence(input);
    }
}
