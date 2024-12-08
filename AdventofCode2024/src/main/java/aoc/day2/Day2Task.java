package aoc.day2;

import aoc.Task;
import java.util.Objects;
import static aoc.day2.Day2ValidationMethods.*;

public class Day2Task implements Task {
    @Override
    public void execute(String inputFilePath) {
        var input = Objects.requireNonNull(day2processInput(inputFilePath));
        countValidLines(input);
        countTotalValidRows(input);
    }
}
