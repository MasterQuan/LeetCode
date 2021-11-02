package com.quan.array;

import java.util.HashSet;
import java.util.Set;

public class distributeCandies {

    /**
     * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，
     * 每一个数字代表一个糖果。你需要把这些糖果平均分给一个弟弟和一个妹妹。
     * 返回妹妹可以获得的最大糖果的种类数。
     * @param candyType
     * @return
     */
    public int distributeCandies(int[] candyType) {
        int half = candyType.length >> 1;
        Set<Integer> candies = new HashSet<>();
        for (int candy : candyType) {
            candies.add(candy);
            if (candies.size() >= half)
                return half;
        }
        return candies.size();
    }
}
