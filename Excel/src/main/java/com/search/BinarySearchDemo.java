package com.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Pragram:BinarySearchDemo
 * @Description:TODO 二分查找 前提是arr[]数组应该是有序的
 * @Author:ZhuShiQiang
 * @Create:2020-04-02 14:56:55
 **/
public class BinarySearchDemo {
    public static void main(String[] args) {
        int [] arr = {3, 14, 53, 214,214,214, 542, 748};
        List list = binarySearchList(arr, 0, arr.length - 1, 214);
        System.out.println(list);
    }

    //
    public static int binarySearch(int [] arr,int left,int right,int findVal){
        //没有找到的情况
        if (left > right){
            return -1;
        }
        int mid = (left + right)/2;
        int midVal = arr[mid];
        if (findVal > midVal){
            //向右递归查找
            return binarySearch(arr, mid + 1, right, findVal);
        }else if (findVal < midVal){
            //向左递归查找
            return binarySearch(arr, left, mid - 1, findVal);
        }else {
            //mid就是要找的数的下标
            return mid;
        }
    }

    //如果列表中存在多个和findVal值一样的数据时，返回所有匹配元素的下标
    public static List binarySearchList(int [] arr, int left, int right, int findVal){
        //没有找到的情况
        if (left > right){
            return new ArrayList();
        }
        int mid = (left + right)/2;
        int midVal = arr[mid];
        if (findVal > midVal){
            //向右递归查找
            return binarySearchList(arr, mid + 1, right, findVal);
        }else if (findVal < midVal){
            //向左递归查找
            return binarySearchList(arr, left, mid - 1, findVal);
        }else {
            //mid就是要找的数的下标
            ArrayList<Integer> resList = new ArrayList<>();
            resList.add(mid);
            //向左边查找是否有相同的
            int temp = mid - 1;
            while (true){
                if (temp < left || arr[temp] != findVal){//因为数组前提是有序，所以只需要按顺序往左一个个判断
                    break;
                }
                resList.add(temp);
                temp --;
            }
            //向右边查找是否有相同的
            temp = mid + 1;
            while (true){
                if (temp > right || arr[temp] != findVal){//因为数组前提是有序，所以只需要按顺序往右一个个判断
                    break;
                }
                resList.add(temp);
                temp ++;
            }
            return resList;
        }
    }
}
