package com.quan.array;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        asteroidCollision(new int[]{5, 10, -5});
    }

    public static int[] asteroidCollision(int[] asteroids) {
        int[] res = new int[0];
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < asteroids.length; i++) {
            list.add(asteroids[i]);
        }

        int i = list.size() - 1;
        while (i > 0) {
            if (i > list.size() - 1) {
                i--;
            } else {
                int a = list.get(i - 1), b = list.get(i), s;
                System.out.println("a--" + a + "|b--" + b);
                if (a > 0 && b < 0) {
                    s = a + b;
                    if (s == 0) {
                        list.remove(i - 1);
                        list.remove(i - 1);
                    } else {
                        list.remove(i - 1);
                        list.set(i - 1, s > 0 ? a : b);
                    }
                } else {
                    i--;
                }
            }
        }
        res = new int[list.size()];
        for (int j = 0; j < list.size(); j++) {
            res[j] = list.get(j);
            System.out.println("===" + res[j]);
        }
        return res;
    }

    public int[] asteroidCollision2(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length;) {
            int b = asteroids[i];
            if (stack.isEmpty()) {
                stack.push(b);
                i++;
            } else {
                int a = stack.peek(), s;
                if (a > 0 && b < 0) {
                    s = a + b;
                    if (s == 0) {
                        stack.pop();
                        i++;
                    } else if (s < 0) {
                        stack.pop();
                    } else {
                        i++;
                        continue;
                    }
                } else {
                    stack.push(b);
                    i++;
                }
            }
        }

        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
