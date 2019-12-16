package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] a = new int[]{3, 1, 2, 0};
       // System.out.print(Arrays.toString(selectSort(a)));
        // System.out.print(Arrays.toString(bubbleSort(a)));
        quickSort(a,0,a.length-1);
        System.out.print(Arrays.toString(a));
    }

    private static int[] selectSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int temp = a[i];
            int flag = i;
            for (int j = i; j < n; j++) {
                if (a[j] <= temp) {
                    temp = a[j];
                    flag = j;
                }
            }
            if (flag != i) {
                a[flag] = a[i];
                a[i] = temp;
            }
        }
        return a;
    }

    private static int[] bubbleSort(int[] a) {
        int n = a.length;
        int temp;
        for (int i = 0; i < n - 1; i++){
            for (int j = 0; j < n-i-1; j++){
                if (a[j]>a[j+1]){
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        return a;
    }
    /**
     * 快速排序算法
     */
    private  static void quickSort(int[] list, int left, int right) {
        if (left < right) {
            // 分割数组，找到分割点
            int point = partition(list, left, right);

            // 递归调用，对左子数组进行快速排序
            quickSort(list, left, point - 1);
            // 递归调用，对右子数组进行快速排序
            quickSort(list, point + 1, right);
        }

    }

    /**
     * 分割数组，找到分割点
     */
    private static int partition(int[] list, int left, int right) {
        // 用数组的第一个元素作为基准数
        int first = list[left];
        while (left < right) {
            while (left < right && list[right] >= first) {
                right--;
            }
            // 交换
            swap(list, left, right);

            while (left < right && list[left] <= first) {
                left++;
            }
            // 交换
            swap(list, left, right);
        }
        // 返回分割点所在的位置
        return left;
    }

    /**
     * 交换数组中两个位置的元素
     */
    private static void swap(int[] list, int left, int right) {
        int temp;
        if (list != null && list.length > 0) {
            temp = list[left];
            list[left] = list[right];
            list[right] = temp;
        }
    }
}
