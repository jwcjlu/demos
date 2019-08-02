package com.jwcjlu.demos.algor;

import java.util.Arrays;

/**
 * 快速排序
 * Created by jwcjlu on 2019/8/2.
 */
public class QuickSort {
    public static void quickSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int index, int length) {
        int i = index, j = length;
        if (i + 1 >= j) {
            return;
        }
        int val = arr[i];
        int or = i;
        for (; i < j; ) {
            if (arr[j] > val) {
                j--;
                continue;
            }
            if (arr[i] <= val) {
                i++;
                continue;
            }
            swap(arr, i, j);
        }
        swap(arr, index, i);
        sort(arr, index, i);
        sort(arr, i + 1, length);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] data = {4, 3, 10, 1, 6, 5, 11, 7, 2, 9, 8};
        System.out.println(Arrays.toString(data));
        quickSort(data);
        System.out.println(Arrays.toString(data));
    }
}
