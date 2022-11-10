package HW_15;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LeetcodeServiceTest {

    public LeetcodeService leetcodeService;

    @Before
    public void init() {
        leetcodeService = new LeetcodeService();
    }

    @Test
    public void twoSum_ShouldReturnCorrectResult() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = {0, 1};

        Assert.assertArrayEquals(result, leetcodeService.twoSum(nums, target));
    }

    @Test
    public void twoSum_ShouldReturnEmptyArray() {
        int[] nums = {2, 7, 11, 15};
        int target = 99;
        int[] result = {0, 0};

        Assert.assertArrayEquals(result, leetcodeService.twoSum(nums, target));
    }

    @Test
    public void formFibonacciSequence_ShouldReturnCorrectResult() {
        int input = 4;
        int result = 3;

        Assert.assertEquals(result, leetcodeService.formFibonacciSequence(input));
    }

    @Test(expected = ArithmeticException.class)
    public void formFibonacciSequence_ShouldThrowArithmeticException() {
        leetcodeService.formFibonacciSequence(-1);
    }

}
