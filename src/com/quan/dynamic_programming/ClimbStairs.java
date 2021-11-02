package com.quan.dynamic_programming;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ClimbStairs {
    public static void main(String[] args) {
        ClimbStairs cs = new ClimbStairs();
        System.out.println("--->" + cs.climbStairs(1));
        System.out.println("--->" + cs.climbStairs(2));
        System.out.println("--->" + cs.climbStairs(3));
        System.out.println("--->" + cs.climbStairs(45));
    }

    //使用递归，时间比较久，存在重复计算
    public int climbStairs(int n) {

        if (n < 2) return 1;

        int[] times = new int[n];
        times[0] = 1;
        times[1] = 1;
        for (int i = 2; i < n; i++) {
            times[i] = times[i - 2] + times[ i - 1];
        }
        return times[n - 2] + times[n - 1];
    }

    //使用递归，时间比较久，存在重复计算
    public int climbStairs2(int n) {
        if (n < 2) return 1;
        return climbStairs2(n -1) + climbStairs2(n - 2);
    }

    //减少存储空间
    public int climbStairs3(int n) {
        if (n < 2) return 1;
        int cnt_n1 = 1;
        int cnt_n2 = 1;
        for (int i = 2; i <= n; i++) {
            int cnt_n = (cnt_n1 + cnt_n2) % 1000000007;
            cnt_n1 = cnt_n2;
            cnt_n2 = cnt_n;
        }
        return cnt_n2;
    }

}

