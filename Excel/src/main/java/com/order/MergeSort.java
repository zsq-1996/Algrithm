package com.order;

/**
 * Author: Zsq
 * Description TODO:归并排序
 * Time:2020/11/1 0001 上午 10:29
 */
public class MergeSort {

    public static void main(String[] args) {
        int []a = {6,3,5,8,1,9};
        int []temp = new int[a.length];
        mergeSort(a, 0, a.length -1, temp);
        //
        printArr(a);
    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp){
        if (left < right){
            int mid = (left + right)/2;
            //向左递归分解
            mergeSort(arr, left, mid, temp);
            //向右递归分解
            mergeSort(arr, mid + 1, right, temp);
            //
            merge(arr,left, right, mid,temp);
        }
    }

    public static void merge(int[] arr, int left, int right, int mid, int[] temp){
        int i = left;
        int j = mid + 1;
        int index = 0;
        //（1）
        //把左右两边有序的数据填充到temp数组
        //直到有一边处理完毕
        while (i<=mid && j<=right){
            //分成左右两组，按顺序比较两组的每一个元素
            if (arr[i] <= arr[j] ){
                temp[index] = arr[i];
                index ++;
                i ++;
            }else {
                temp[index] = arr[j];
                index ++;
                j ++;
            }
        }

        //(2)
        //检查剩余情况
        //把另一边剩余元素填充到temp
        while (i <= mid){
            temp[index] = arr[i];
            index ++;
            i ++;
        }
        while (j <= right){
            temp[index] = arr[j];
            index ++;
            j ++;
        }

        //（3)
        //temp数组拷贝到arr
        int templeft = left;
        index = 0;
        while (templeft <= right){
            arr[templeft] = temp[index];
            index ++;
            templeft ++;
        }

    }

    public static void printArr(int []arr){
        for (int i : arr){
            System.out.print(i + " ");
        }
    }
}
