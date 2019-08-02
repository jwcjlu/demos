package com.jwcjlu.demos.algor;

import java.util.Arrays;

/**
 * 插入排序
 * Created by jwcjlu on 2019/8/1.
 */
public class InsertSort {
    public static void sort(int[]data){
        for(int i=0;i<data.length;i++){
            for(int j=0;j<i;j++){
                if(data[j]>data[i]){
                    ajustSort(data,j,i);
                    break;

                }
            }
        }
    }
    private static void ajustSort(int []data,int from,int to){
        int temp=data[to];
        for(int i=to;i>from;i--){
            data[i]=data[i-1];
        }
        data[from]=temp;
    }

    public static void main(String[] args) {
        int []data={4,3,2,1,6,5,11,7,10,9,8};
        System.out.println(Arrays.toString(data));
        sort(data);
        System.out.println(Arrays.toString(data));
    }

}
