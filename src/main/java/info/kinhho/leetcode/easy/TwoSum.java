package info.kinhho.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */
public class TwoSum {

    public static int[] bestSolution(int[] nums, int target) {

        // One time pass hash table -> O(n), S(n)
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static int[] mySolution(int[] nums, int target) {

        // Bruteforce -> O(n^2), S(1)
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++ ) {
                if ( target - nums[i] == nums[j]) {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {

        int[] nums = new int[] {1,2,3,48,6,4,7,9,10};
        System.out.println( Arrays.toString( bestSolution(nums,58 ) ) );
        System.out.println( Arrays.toString( mySolution(nums,58 ) ) );
    }
}
