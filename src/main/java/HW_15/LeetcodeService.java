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
}
