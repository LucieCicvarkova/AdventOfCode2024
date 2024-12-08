package aoc.day2;

import java.util.List;

public class Day2ValidationResult {
    private final int validRows;
    private final List<List<Integer>> invalidRows;

    public Day2ValidationResult(int validRows, List<List<Integer>> invalidRows) {
        this.validRows = validRows;
        this.invalidRows = invalidRows;
    }

    public int getValidRows() {
        return validRows;
    }

    public List<List<Integer>> getInvalidRows() {
        return invalidRows;
    }
}
