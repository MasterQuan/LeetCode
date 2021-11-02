package com.quan.array;

import com.sun.scenario.effect.Brightpass;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target的那两个整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * <p>
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum {

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] nums = {3, 2, 4};
        System.out.println(Arrays.toString(ts.twoSum(nums, 5)));
        System.out.println(Arrays.toString(ts.twoSum(nums, 6)));
        System.out.println(Arrays.toString(ts.twoSum(nums, 7)));
    }

    /**
     * 给定一个整数数组 nums和一个整数目标值 target，
     * 请你在该数组中找出 和为目标值 target的那两个整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] ns = new int[2];
        //创建一个hashmap存储nums
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hash.put(nums[i], i);
        }

        for (int n0 = 0; n0 < nums.length; n0++) {
            if (hash.containsKey(target - nums[n0]) && hash.get(target - nums[n0]) != n0) {
                ns[0] = n0;
                ns[1] = hash.get(target - nums[n0]);
                break;
            }
        }
        return ns;
    }

    /**
     * 给定一个已按照 非递减顺序排列的整数数组numbers ，请你从数组中找出两个数满足相加之和等于目标数target 。
     * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。
     * numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
     * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        if (null == nums || nums.length < 2) {
            return null;
        } else {
            int[] ns = new int[2];
            int left = 0, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] < target) {
                    left++;
                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    ns[0] = nums[left];
                    ns[1] = nums[right];
                    break;
                }
            }
            return ns;
        }
    }
}
