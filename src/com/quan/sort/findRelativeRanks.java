package com.quan.sort;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。
 * 所有得分都 互不相同 。
 * 运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，名次第 2 的运动员得分第 2 高，
 * 依此类推。运动员的名次决定了他们的获奖情况：
 * 名次第 1 的运动员获金牌 "Gold Medal" 。
 * 名次第 2 的运动员获银牌 "Silver Medal" 。
 * 名次第 3 的运动员获铜牌 "Bronze Medal" 。
 * 从名次第 4 到第 n 的运动员，只能获得他们的名次编号（即，名次第 x 的运动员获得编号 "x"）。
 * 使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。
 *
 */
public class findRelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        int max = 0;
        for (int s:score) {
            max = s > max ? s : max;
        }
        int[] index = new int[max + 1];
        Arrays.fill(index,-1);
        for (int i = 0; i < score.length; i++) {
            index[score[i]] = i;
        }
        String[] ranks = new String[score.length];
        int rank = 1;
        while (max >= 0){
            if (index[max] >= 0){
                if (rank == 1) ranks[index[max]] = "Gold Medal";
                else if (rank == 2) ranks[index[max]] = "Silver Medal";
                else if (rank == 3) ranks[index[max]] = "Bronze Medal";
                else ranks[index[max]] = rank + "";
                rank++;
            }
            max--;
        }
        return ranks;
    }
}
