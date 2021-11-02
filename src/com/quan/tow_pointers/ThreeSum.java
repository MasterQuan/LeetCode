package com.quan.tow_pointers;

import com.quan.array.AlienSorted;
import com.sun.java.swing.plaf.windows.WindowsDesktopIconUI;

import java.time.chrono.MinguoDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组nums，判断nums中是否存在三个元素a ，b ，c ，
 * 使得a + b + c = 0 ？请找出所有和为 0 且不重复的三元组。
 *
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]

 * 示例 2：
 * 输入：nums = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[]
 *
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        if (null == nums || nums.length < 3) return results;

        //排序
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2 ; i++){
            if(i > 0 && nums[i-1] == nums[i])
                continue;
            int target = -nums[i], left = i + 1, right = nums.length - 1;
            while(left < right){
                if(nums[left] + nums[right] == target){
                    results.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    int temp = nums[left];
                    while(left < right && nums[left] == temp)
                        left++;
                    temp = nums[right];
                    while(left < right && nums[right] == temp)
                        right--;
                }else if(nums[left] + nums[right] < target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return results;
    }
}
