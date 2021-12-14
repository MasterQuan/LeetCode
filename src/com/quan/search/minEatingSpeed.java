package com.quan.search;

/**
 * 狒狒喜欢吃香蕉。这里有N堆香蕉，第 i 堆中有piles[i]根香蕉。警卫已经离开了，将在H小时后回来。
 * 狒狒可以决定她吃香蕉的速度K（单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。
 * 如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉，
 * 下一个小时才会开始吃另一堆的香蕉。
 * 狒狒喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 */
public class minEatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0, mid = 0, needHours = 0;
        for (int pile : piles) {
            right = right < pile ? pile : right;
        }
        while (left < right){
            needHours = 0;
            mid = (left + right) >> 1;
            for (int pile : piles) {
                needHours += (pile - 1) / mid + 1;
            }
            //需要加快吃的速度
            if (needHours > h){
                left = mid + 1;
            }else {
                //需要减速，找最小速度
                right = mid;
            }
        }
        return mid;
    }
}
