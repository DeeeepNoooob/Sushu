package com.company;


import java.util.LinkedHashSet;

public class Main {
    public static int count = 0;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(zhishu2(100000) + " " + count);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    /**
     * 暴力法
     * @param n
     * @return
     */
    public static LinkedHashSet<Integer> zhishu2(int n) {
        LinkedHashSet<Integer> res = new LinkedHashSet<>();
        for (int i = 1; i <= n; i+=2) {
            if (isSushu1(i)) {
                res.add(i);
            }
            count++;
        }
        return res;
    }

    /**
     * 埃拉托色尼筛选法
     * @param n
     * @return
     */
    public static LinkedHashSet<Integer> zhishu(int n) {
        LinkedHashSet<Integer> res = new LinkedHashSet<>();
        if (n <= 2) {
            res.add(2);
            return res;
        }
        int num = (int) Math.sqrt(n);
//        LinkedHashSet<Integer> arr = new LinkedHashSet<>();//结合小部分暴力法
        LinkedHashSet<Integer> arr = zhishu(num);//递归
//        for (int i = 2; i <= num; i++) {
//            if (isSushu1(i))
//                arr.add(i);
//        }

        res.add(2);
        for (int i = 1; i <= n; i+=2) {
            res.add(i);
        }
        res.remove(1);
        for (Integer integer : arr) {
            int index = integer;
            int i = 2;
            while (integer>=2&&index * i <= n) {
                res.remove(index * i);
                i++;
            }
        }
        return res;
    }

    private static boolean isSushu1(int num) {
        if (num < 2) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }
        for (int i = 3; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }


}





