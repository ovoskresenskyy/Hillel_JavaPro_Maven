package HW_15;

import java.util.HashMap;
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
}
