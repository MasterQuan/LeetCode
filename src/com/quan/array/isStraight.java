package com.quan.array;

public class isStraight {
    /**
     * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，
     * A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
     *
     * 示例:
     * 输入: [1,2,3,4,5]
     * 输出: True
     *
     * 示例:
     * 输入: [0,0,1,2,5]
     * 输出: True
     *
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        //异常数组处理
        if (null == nums || nums.length < 5) return false;

        //存储每张牌出现的次数
        int[] pokers = new int[14];
        int min = 14, max = 0;
        for (int num : nums) {
            //判断异常数据
            if (num > 13 || num < 0) return false;

           pokers[num]++;
           if (num != 0 && pokers[num] > 1){ // 非0出现两次
               return false;
           }
           if (num < min && num != 0) min = num;
           if (num > max) max = num;
        }


        if(min == 0 && max == 0){   //全部为0
            return true;
        }else {
            if(max - min <= 4){
                return true;
            }else {
                return false;
            }
        }
    }
}
