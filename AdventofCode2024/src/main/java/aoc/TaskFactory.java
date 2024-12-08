package aoc;

import aoc.day1.Day1Task;
import aoc.day2.Day2Task;
import aoc.day3.Day3Task;
import aoc.day4.Day4Task;

import java.util.HashMap;
import java.util.Map;

public class TaskFactory {
    private static final Map<String, Task> tasks = new HashMap<>();

    static {
        tasks.put("day1", new Day1Task());
        tasks.put("day2", new Day2Task());
        tasks.put("day3", new Day3Task());
        tasks.put("day4", new Day4Task());
    }

    public static Task getTask(String key) {
        return tasks.get(key.toLowerCase());
    }
}
