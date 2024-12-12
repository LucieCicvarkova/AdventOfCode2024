package aoc.day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Day4 {
    public static char[][] processInputDay4(String fileName) {
        try (Stream<String> linesStream = Files.lines(Paths.get(fileName))) {
            char[][] lettersArray = linesStream
                    .map(String::toCharArray)
                    .toArray(char[][]::new);
            return lettersArray;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int[] countWordOccurrence(char[][] array) {
        int xmasCount = 0;
        int masCount = 0;

        for (int row = 0; row < array.length; row++) {
            for (int index = 0; index < array[row].length; index++) {

                if (checkWord(array, row, index, 0, 1)) xmasCount++;  // row to right
                if (checkWord(array, row, index, 0, -1)) xmasCount++; // row to left
                if (checkWord(array, row, index, 1, 0)) xmasCount++;  // column down
                if (checkWord(array, row, index, -1, 0)) xmasCount++; // column up
                if (checkWord(array, row, index, 1, 1)) xmasCount++;  // diagonal down right
                if (checkWord(array, row, index, -1, -1)) xmasCount++; // diagonal up left
                if (checkWord(array, row, index, +1, -1)) xmasCount++; // diagonal down left
                if (checkWord(array, row, index, -1, +1)) xmasCount++; // diagonal up right

                if (checkMAS(array, row, index)) {
                    masCount++;
                }
            }
        }

        System.out.println("Xmas word count is: " + xmasCount);
        System.out.println("MAS word count is: " + masCount);

        return new int[]{xmasCount, masCount};
    }

    private static boolean checkWord(char[][] array, int row, int col, int rowStep, int colStep) {
        String word = "XMAS";
        for (int i = 0; i < word.length(); i++) {
            int newRow = row + i * rowStep;
            int newCol = col + i * colStep;

            if (newRow < 0 || newRow >= array.length || newCol < 0 || newCol >= array[row].length) {
                return false;
            }

            if (array[newRow][newCol] != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkMAS(char[][] array, int row, int col) {
        boolean hasNeighbors = row > 0 && row < array.length - 1 && col > 0 && col < array[0].length - 1;
        if (!hasNeighbors) {
            return false;
        }

        char central = array[row][col];
        char upleft = array[row - 1][col - 1];
        char upright = array[row - 1][col + 1];
        char downright = array[row + 1][col + 1];
        char downleft = array[row + 1][col - 1];

        if (central != 'A') {
            return false;
        }

        if (upleft == 'M' && upright == 'S' && downright == 'S' && downleft == 'M'
                || upleft == 'M' && upright == 'M' && downright == 'S' && downleft == 'S'
                || upleft == 'S' && upright == 'M' && downright == 'M' && downleft == 'S'
                || upleft == 'S' && upright == 'S' && downright == 'M' && downleft == 'M'
        ) {
            return true;
        }
        return false;
    }
}
