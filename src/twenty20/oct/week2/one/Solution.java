package twenty20.oct.week2.one;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author snehasish
 */
class Solution {

    /**
     * This method utilizes the out of the box binary search feature of
     * <code>java.util.Arrays.binarySearch()</code>
     *
     * @param nums   the sorted integer array
     * @param target the integer which needs to be searched
     * @return if <strong>target</strong> is found in <strong>nums</strong>, returns the index position.
     * Or else, returns -1.
     */
    public int search(int[] nums, int target) {
        int result = Arrays.binarySearch(nums, target);
        if (result >= 0)
            return result;
        return -1;
    }

    /**
     * This method uses a custom binary search algorithm with the help of private method
     * <code>solution()</code>.
     * @param nums the sorted integer array
     * @param target the integer which needs to be searched
     * @return if <strong>target</strong> is found in <strong>nums</strong>, returns the index position.
     * Or else, returns -1.
     */
    public int customSearch(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        else {
            int left = 0;
            int right = nums.length - 1;
            if (left < right)
                return solution(nums, left, right, target);
        }
        return -1;
    }

    /**
     * simple binary search algorithm using recursion.
     * @param nums the sorted integer array
     * @param left left search bound, the target is definitely to the right side for this specific
     *             call stack
     * @param right right search bound, the target is definitely to the left side for this specific
     *              call stack
     * @param target the integer which needs to be searched
     * @return if <strong>target</strong> is found in <strong>nums</strong>, returns the index position.
     * Or else, returns -1.
     */
    private int solution(int[] nums, int left, int right, int target) {
        int median = (left + right) / 2;
        if (left > right)
            return -1;
        else if (nums[median] == target)
            return median;
        else if (nums[median] < target)
            return solution(nums, median + 1, right, target);
        else
            return solution(nums, left, median - 1, target);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the length of the array: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the array elements in sorted order: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println("Enter the target number: ");
        int target = scanner.nextInt();
        System.out.println("Result using out of the box algorithm: " + solution.search(nums, target));
        System.out.println("Result using custom algorithm: " + solution.customSearch(nums, target));
    }
}
