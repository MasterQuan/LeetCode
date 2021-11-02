package com.quan.queue;

import java.util.LinkedList;
import java.util.Queue;

public class AnimalShelf {
    Queue<int[]> cats;
    Queue<int[]> dogs;
    private static final int[] abnormal_value = new int[]{-1,-1};

    public AnimalShelf() {
        cats = new LinkedList<>();
        dogs = new LinkedList<>();
    }

    public void enqueue(int[] animal)
    {
        if(animal[1] == 0){
            cats.offer(animal);
        } else dogs.offer(animal);
    }

    public int[] dequeueAny() {
        if( (null == cats || cats.isEmpty())
                &&(null == dogs || dogs.isEmpty()))
            return abnormal_value;

        if(cats.isEmpty() || dogs.isEmpty()) {
            return !cats.isEmpty() ? cats.poll() : dogs.poll();
        }

        if (cats.peek()[0] < dogs.peek()[0]){
            return cats.poll();
        }else {
            return dogs.poll();
        }
    }

    public int[] dequeueDog() {
        if (null == dogs || dogs.isEmpty()) {
            return abnormal_value;
        }else {
            return dogs.poll();
        }
    }

    public int[] dequeueCat() {
        if (null == cats || cats.isEmpty()){
            return abnormal_value;
        }else {
            return cats.poll();
        }
    }
}
