package HW_15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetcodeService {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> integers = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (integers.containsKey(difference)) return new int[]{integers.get(difference), i};
            else integers.put(nums[i], i);
        }
        return new int[2];
    }

    public int formFibonacciSequence(int input) throws ArithmeticException {
        if (input < 0) throw new ArithmeticException();

        int[] fibonacciSequence = new int[input + 2];
        fibonacciSequence[0] = 0;
        fibonacciSequence[1] = 1;
        for (int i = 2; i <= input; i++) {
            fibonacciSequence[i] = fibonacciSequence[i - 1] + fibonacciSequence[i - 2];
        }
        return fibonacciSequence[input];
    }

    public List<List<Integer>> generatePascalsTriangle(int numRows) throws ArithmeticException {
        if (numRows < 0) throw new ArithmeticException();

        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) return result;

        List<Integer> firstLine = new ArrayList<>();
        firstLine.add(1);
        result.add(firstLine);
        if (numRows == 1) return result;

        List<Integer> lastLine = new ArrayList<>();
        lastLine.add(1);
        lastLine.add(1);
        result.add(lastLine);
        if (numRows == 2) return result;

        for (int row = 3; row <= numRows; row++) {
            List<Integer> nextLine = new ArrayList<>();

            for (int cell = 0; cell < row; cell++) {
                if (cell == 0 || cell == row - 1) nextLine.add(1);
                else {
                    int cellValue = lastLine.get(cell) + lastLine.get(cell - 1);
                    nextLine.add(cellValue);
                }
            }
            result.add(nextLine);
            lastLine = nextLine;
        }

        return result;
    }
}
