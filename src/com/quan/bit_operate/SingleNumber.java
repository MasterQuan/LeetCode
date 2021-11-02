package com.quan.bit_operate;

import java.util.Arrays;

public class SingleNumber {
    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。
     * 找出那个只出现了一次的元素。
     * 说明：
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     *
     * 示例 1:
     * 输入: [2,2,1]
     * 输出: 1
     *
     * 示例2:
     * 输入: [4,1,2,1,2]
     * 输出: 4
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        if (null == nums || nums.length < 1) return -1;
        int single = nums[0];
        for (int i = 1; i < nums.length; i++) {
            single = single ^ nums[i];
        }
        return single;
    }

    /**
     * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
     *
     * 进阶：
     * 你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?
     *
     * 示例 1：
     * 输入：nums = [3,0,1]
     * 输出：2
     * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
     *
     * 示例 2：
     * 输入：nums = [0,1]
     * 输出：2
     * 解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        if (null == nums || nums.length < 1){
            return -1;
        }else {
            int missing = nums[0] ^ 0;
            int i = 1;
            for (; i < nums.length;i++){
                missing ^= i;
                missing ^= nums[i];
            }
            return missing ^ i;
        }
    }
    public int singleNumber2(int[] nums) {
        int ones = 0;
        int twos = 0;

        for (int i = 0; i < nums.length; i++) {
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }
        return ones;
    }

    public int[] singleNumber3(int[] nums) {

        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        int flag = xor & (-xor);
        int[] singles = new int[2];
        for (int num : nums) {
            if ((num & flag) == 0){
                singles[0] ^= num;
            }else{
                singles[1] ^= num;
            }
        }
        return singles;
    }

}
