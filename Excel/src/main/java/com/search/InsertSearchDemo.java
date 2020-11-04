package com.search;

/**
 * @Pragram:InsertSearchDemo
 * @Description:TODO 插值查找算法 arr前提是有序的
 * @Author:ZhuShiQiang
 * @Create:2020-04-02 16:06:35
 **/
public class InsertSearchDemo {
    public static void main(String[] args) {
//        int [] arr = new int[100];
//        for (int i = 0; i < arr.length; i ++){
//            arr [i] = i;
//        }
        int [] arr2 = {3, 14, 53, 214, 542, 748};
        int res = insertSearch(arr2, 0, arr2.length - 1, 53);
        System.out.println(res);
    }

    public static int insertSearch(int []arr,int left,int right,int findVal){
        if (left > right || findVal < arr[left] || findVal > arr[right]){//因为arr前提是有序的，所以findVal不能比最小的还小
            return -1;
        }
        int mid = left + (right - left)*(findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal){//向右递归查找
            return insertSearch(arr, mid + 1, right, findVal);
        }else if (findVal < midVal){//向左递归查找
            return insertSearch(arr, left, mid - 1, findVal);
        }else {
            return mid;
        }
    }
}
