package com.quan.string;

public class getHint {
    /**
     * 你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：
     * 写出一个秘密数字，并请朋友猜这个数字是多少。朋友每猜测一次，你就会给他一个包含下述信息的提示：
     * 猜测数字中有多少位属于数字和确切位置都猜对了（称为 "Bulls", 公牛），
     * 有多少位属于数字猜对了但是位置不对（称为 "Cows", 奶牛）。
     * 也就是说，这次猜测中有多少位非公牛数字可以通过重新排列转换成公牛数字。
     * 给你一个秘密数字secret 和朋友猜测的数字guess ，请你返回对朋友这次猜测的提示。
     * 提示的格式为 "xAyB" ，x 是公牛个数， y 是奶牛个数，A 表示公牛，B表示奶牛。
     * 请注意秘密数字和朋友猜测的数字都可能含有重复数字。
     *
     * @param secret
     * @param guess
     * @return
     */
    public String getHint(String secret, String guess) {
        int[] s_digit = new int[10];
        int[] g_digit = new int[10];
        int bulls = 0, cows = 0;
        int digitS, digitG;
        for (int i = 0; i < guess.length(); i++) {
            digitS = secret.charAt(i) - '0';
            digitG = guess.charAt(i) - '0';
            if (digitS == digitG){
                bulls++;
            }else {
                s_digit[digitS]++;
                g_digit[digitG]++;
            }
        }
        for (int i = 0; i < s_digit.length; i++) {
            cows += Math.min(s_digit[i], g_digit[i]);
        }

        return new StringBuilder().append(bulls).append('A').append(cows).append('B').toString();
    }
}
