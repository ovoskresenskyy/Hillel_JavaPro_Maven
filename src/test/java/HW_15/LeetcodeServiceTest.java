package HW_15;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void generatePascalsTriangle_ShouldReturnCorrectResult() {
        int numRows = 5;
        List<List<Integer>> expectedResult = new ArrayList<>();
        expectedResult.add(new ArrayList<>(List.of(1)));
        expectedResult.add(new ArrayList<>(List.of(1, 1)));
        expectedResult.add(new ArrayList<>(List.of(1, 2, 1)));
        expectedResult.add(new ArrayList<>(List.of(1, 3, 3, 1)));
        expectedResult.add(new ArrayList<>(List.of(1, 4, 6, 4, 1)));

        Assert.assertEquals(expectedResult, leetcodeService.generatePascalsTriangle(numRows));
    }

    @Test
    public void generatePascalsTriangle_ShouldReturnEmptyArrayList() {
        Assert.assertEquals(new ArrayList<>(), leetcodeService.generatePascalsTriangle(0));
    }

    @Test(expected = ArithmeticException.class)
    public void generatePascalsTriangle_ShouldThrowArithmeticException() {
        leetcodeService.generatePascalsTriangle(-1);
    }
}
