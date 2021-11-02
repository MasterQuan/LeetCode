package com.quan.dynamic_programming;


public class Rob {
    /**
     * 一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
     * 影响小偷偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 给定一个代表每个房屋存放金额的非负整数数组 nums ，
     * 请计算不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     *
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        //前一个最大值
        int pre1 = nums[0];
        //前两个最大值
        int pre2 = 0;
        //当前最大值
        int v = pre1;
        for (int i = 1; i < nums.length; i++) {
            v = Math.max(pre1, pre2 + nums[i]);
            pre2 = pre1;
            pre1 = v;
        }
        return v;
    }

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
     * 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
     * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
     *
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        if (nums.length == 1) return nums[0];
        //前一个最大值
        int pre1 = nums[0];
        //前两个最大值
        int pre2 = 0;
        //当前最大值
        int v1 = pre1;
        for (int i = 1; i < nums.length - 1; i++) {
            v1 = Math.max(pre1, pre2 + nums[i]);
            pre2 = pre1;
            pre1 = v1;
        }

        //重新初始化
        pre1 = nums[1];
        pre2 = 0;
        int v2 = pre1;
        for (int i = 2; i < nums.length; i++) {
            v1 = Math.max(pre1, pre2 + nums[i]);
            pre2 = pre1;
            pre1 = v1;
        }
        return Math.max(v1, v2);
    }
}
