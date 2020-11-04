package com.sort;

import java.util.Arrays;

/**
 * @Pragram:MergeSort
 * @Description:TODO 归并排序
 * @Author:ZhuShiQiang
 * @Create:2020-04-02 09:47
 **/
public class MergeSortDemo {
    public static void main(String[] args) {
        int []a = {6,3,5,8,1,9};
        int []temp = new int[a.length];
        mergeSort(a, 0, a.length-1, temp);
        System.out.println(Arrays.toString(a));
    }

    public static void mergeSort(int []arr,int left,int right,int []temp){
        if (left < right){
            int mid = (left + right) / 2;
            //向左分解
            mergeSort(arr, left, mid, temp);
            //向右分解
            mergeSort(arr, mid + 1, right, temp);
            //最后合并
            merge(arr, left, mid, right, temp);
        }
    }
    /**
     * @Author ZhuShiQiang
     * @Description //TODO 合并方法
     * @Date  2020/4/2
     * @param arr 需要排序的原始数组
     * @param left 左边有序序列的初始索引
     * @param mid 中间索引
     * @param right 右边索引
     * @param temp 合并需要用到的中转数组
     * @return 
     **/
    public static void merge(int []arr,int left,int mid,int right,int []temp){
        int i = left;
        int j = mid + 1;
        int tempIndex = 0;//temp数组的当前索引,为1
        //1、先把左右两边的数据按照规则填充到temp数组
        //直到有一边的序列数据全部处理完毕
        while (i <= mid && j <= right){
            if (arr[i] < arr[j]){
                temp[tempIndex] = arr[i];
                tempIndex ++;
                i ++;
            }else {
                temp[tempIndex] = arr[j];
                tempIndex ++;
                j ++;
            }
        }
        //2、然后把剩余一边的数据依次放到temp数组
        //如果是左边的没有剩余，右边有剩余
        while (j <= right) {
            temp[tempIndex] = arr[j];
            tempIndex++;
            j++;
        }

        //如果是右边的没有剩余，左边有剩余
        while (i <= mid) {
            temp[tempIndex] = arr[i];
            tempIndex++;
            i++;
        }

        //将temp数组中的元素拷贝到arr
        tempIndex = 0;
        int tempLeft = left;
        while (tempLeft <= right){
            arr[tempLeft] = temp[tempIndex];
            tempLeft ++;
            tempIndex ++;
        }
    }
}
