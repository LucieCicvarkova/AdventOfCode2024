package aoc.day1;

import aoc.Task;
import java.util.Objects;
import static aoc.day1.Day1.*;

public class Day1Task implements Task {
    @Override
    public void execute(String inputFilePath) {
        var input = Objects.requireNonNull(processInput(inputFilePath));
        getDifferencesSum(input);
        getFrequenciesSum(input);
    }
}
