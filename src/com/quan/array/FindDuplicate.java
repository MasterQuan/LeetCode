package com.quan.array;

import javax.xml.stream.FactoryConfigurationError;
import java.util.LinkedList;
import java.util.List;

public class FindDuplicate {

    /**
     * 给定一个包含n + 1 个整数的数组nums ，其数字都在 1 到 n之间（包括 1 和 n），
     * 可知至少存在一个重复的整数。
     * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
     * 你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        while (true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast){
                slow = 0;
                while (nums[slow] != nums[fast]){
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return nums[slow];
            }
        }
    }

    /**
     * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
     *
     * 示例 1:
     * 输入: nums = [1,1,2,3,3,4,4,8,8]
     * 输出: 2
     *
     * 示例 2:
     * 输入: nums =  [3,3,7,7,10,11,11]
     * 输出: 10
     *
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];
        for (int i = 0; i < nums.length; i += 2) {
            if (i == nums.length - 1) return nums[i];
            if ((nums[i] ^ nums[i + 1]) != 0) return nums[i];
        }
        return -1;
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        int[] flags = new int[nums.length + 1];
        for (int num:nums) {
            flags[num]++;
            if (flags[num] == 2) ans.add(num);
        }
        return ans;
    }

    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            nums[(nums[i] - 1) % nums.length] += nums.length;
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > nums.length << 1) ans.add(i + 1);
        }
        return ans;
    }
}
