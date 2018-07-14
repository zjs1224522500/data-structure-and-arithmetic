package me.elvis.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * <p>
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * <p>
     * Example:
     * *********************************************
     * * Given nums = [2, 7, 11, 15], target = 9   *
     * * Because nums[0] + nums[1] = 2 + 7 = 9,    *
     * * return [0, 1].                            *
     * *********************************************
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        new TwoSum().twoSumWithLoop(nums, target);
        new TwoSum().twoSumWithMap(nums, target);
    }

    /**
     * Use loop to add two of given num array.
     * And judge if target is equal to the sum result.
     * If equals, store the index of two numbers.
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumWithLoop(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    /**
     * Use loop to add all nums in array to a hash map.[value,index]
     * In the add-to-map process, calculate target minus the number [A] which is going to be added.
     * And judge if hash map key set contains the calculated value [B].
     * <p>
     * If contains,return the array.[A.index,B -> value in Map(index)]
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumWithMap(int[] nums, int target) {
        Map<Integer, Integer> data = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (data.containsKey(complement)) {
                return new int[]{i, data.get(complement)};
            }
            data.put(nums[i], i);
        }
        return null;
    }
}
