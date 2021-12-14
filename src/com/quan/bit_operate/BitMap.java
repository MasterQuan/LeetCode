package com.quan.bit_operate;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 假设所有的数字都是非负数。
 */
public class BitMap {
    private byte[] bitmap;

    //默认构造最大的存储整数的Byte数组
    BitMap(){
        bitmap = new byte[(Integer.MAX_VALUE >> 3) + 1];
    }

    //根据最大值构造存储整数的Byte数组
    BitMap(int max){
        bitmap = new byte[(max >> 3) + 1];
    }

    //向bitmap中插入一批整数
    public void insert(int[] nums){
        for (int num : nums) {
            insert(num);
        }
    }

    //向bitmap中插入一个整数
    public void insert(int num){
        bitmap[num >> 3] |= (128 >> (num % 8));
    }

    //判断某个数是否存在
    public boolean find(int num){
        return (bitmap[num >> 3] & (128 >> (num % 8))) == 0 ? false : true;
    }

    //从bitmap中移除一批整数
    public void remove(int[] nums){
        for (int num : nums) {
            remove(num);
        }
    }

    //从bitmap中移除一个整数
    public void remove(int num){
        bitmap[num >> 3] &= ~(128 >> (num % 8));
    }

    //顺序获取bitmap中的所有整数
    public List<Integer> collect(){
        List<Integer> set = new LinkedList<>();
        int count = 0;
        for (byte b : bitmap) {
            for (int j = 128; j > 0 ; j >>= 1, count++) {
                if ((b & j) != 0){
                    set.add(count);
                }
            }
        }
        return set;
    }


    public static void main(String[] args) {
        BitMap bitMap = new BitMap(100000);
        bitMap.insert(22);
        bitMap.insert(7);
        System.out.println(bitMap.find(3) + " " + bitMap.find(7));
        bitMap.remove(13);
        System.out.println(bitMap.find(3) + " " + bitMap.find(7));

        bitMap.insert(3);
        bitMap.insert(15);
        System.out.println(bitMap.find(13) + " " + bitMap.find(15));

        bitMap.insert(21);
        bitMap.insert(16);
        System.out.println(bitMap.find(22) + " " + bitMap.find(16));
        for ( int i: bitMap.collect()) {
            System.out.println("----" + i);
        }
    }
}
