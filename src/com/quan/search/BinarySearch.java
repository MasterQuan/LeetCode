package com.quan.search;

/**
 * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，
 * 写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 *
 * 示例 1:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例2:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 *
 *
 * 提示：
 *
 * 你可以假设 nums中的所有元素是不重复的。
 * n将在[1, 10000]之间。
 * nums的每个元素都将在[-9999, 9999]之间。
 *
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {0};
        BinarySearch bs = new BinarySearch();

        System.out.println(bs.search(nums, -1));
        System.out.println(bs.search(nums, 0));
        System.out.println(bs.search(nums, 1));

    }

    public int search(int[] nums, int target) {
        int pos = -1;
        if (nums == null || nums.length < 1) return pos;

        //二分查找
        int i = 0, j = nums.length -1;
        for (pos = (i+j)/2; i <= j;){
            if (target == nums[pos]) return pos;
            if (target > nums[pos]){
                i = pos + 1;
                pos = (i + j)/2;
            }else {
                j = pos - 1;
                pos = (i + j)/2;
            }
        }
        if (target == nums[pos]) return pos;
        return -1;
    }

    /**
     * 统计一个数字在排序数组中出现的次数。
     *
     * 示例 1:
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: 2
     *
     * 示例2:
     * 输入: nums = [5,7,7,8,8,10], target = 6
     * 输出: 0
     *
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        int pos = 0;
        if (nums == null || nums.length < 1) return 0;

        //二分查找
        int i = 0, j = nums.length -1;
        for (pos = (i+j)/2; i <= j;){
            if (target == nums[pos]) break;
            if (target > nums[pos]){
                i = pos + 1;
                pos = (i + j)/2;
            }else {
                j = pos - 1;
                pos = (i + j)/2;
            }
        }
        int cnt = 0;
        if (target == nums[pos]){
            cnt++;
            for (int k = (pos-1); k >= 0 && nums[k]==target; k--) {
                    cnt++;
            }
            for (int k = (pos+1); k < nums.length && nums[k]==target; k++) {
                    cnt++;
            }
            return cnt;
        }else return 0;
    }
}
