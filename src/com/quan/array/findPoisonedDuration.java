package com.quan.array;

public class findPoisonedDuration {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int sum = duration;
        for(int i = 1; i < timeSeries.length; i++){
            sum += Math.min(duration, timeSeries[i]-timeSeries[i-1]);
        }
        return sum;
    }
}
