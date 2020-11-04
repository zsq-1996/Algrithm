package com.sort;

import java.util.Arrays;

/**
 * Author: Zsq
 * Description TODO:快速排序
 * Time:2020/4/1 0001 下午 9:14
 */
public class QuickSortDemo {
    public static void main(String[] args) {
        int []a = {6,3,5,8,1,9};
        quickSort(0,a.length-1,a);
        System.out.println(Arrays.toString(a));
    }
    public static void quickSort(int left,int right, int []arr){
        int l = left;
        int r = right;
        //中间值
        int pivot = arr [(left + right)/2];
        //临时变量(交换时使用)
        int temp = 0;
        while (l < r){
            while (arr[l] < pivot){//在中间值左边找到一个大于中间值的元素，然后退出循环
                l += 1;
            }
            while (arr[r] > pivot){//在中间值右边找到一个小于等于中间值的元素，然后退出循环
                r -= 1;
            }
            if (l >= r){//说明中间值左边的元素都是小于pivot的，右边的都是大于pivot的
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == pivot){
                r --;
            }
            if (arr[r] == pivot){
                l ++;
            }
        }
        if (l == r){//没有这一步会栈溢出
            l ++;
            r --;
        }
        //向左递归，中间值左边的所有元素
        if (left < r){
            quickSort(left,r,arr);
        }
        //向右递归
        if (right > l){
            quickSort(l,right,arr);
        }
    }

    public static void printArr(int []arr){
        for (int i : arr){
            System.out.print(i + " ");
        }
    }
}
