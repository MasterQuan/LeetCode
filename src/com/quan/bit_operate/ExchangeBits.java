package com.quan.bit_operate;

public class ExchangeBits {
    public int exchangeBits(int num) {
        return ((num & 0xaaaaaaaa) >>> 1) | ((num & 0x55555555) << 1);
    }
}
