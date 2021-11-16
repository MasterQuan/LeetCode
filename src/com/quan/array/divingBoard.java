package com.quan.array;

import java.util.HashSet;
import java.util.Set;

public class divingBoard {
    /**
     * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，
     * 长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
     * 返回的长度需要从小到大排列。
     *
     * @param shorter
     * @param longer
     * @param k
     * @return
     */
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[0];
        int[] ans;
        if(shorter == longer){
            ans = new int[1];
            ans[0] = shorter * k;
            return ans;
        }
        ans = new int[k + 1];
        for (int s = k, l = 0, pos = 0; s >= 0; s--, l++, pos++) {
            ans[pos] = shorter * s + longer * l;
        }
        return ans;
    }
}
