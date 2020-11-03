package com.order;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Zsq
 * Description TODO: 二分查找，有一个前提，就是目标数组必须是已经排好序
 * Time:2020/11/3 0003 下午 8:28
 */
public class BinarySearchDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        Object o = binarySearch(arr, 0, 5, 2);
        System.out.println(o);
    }

    public static Object binarySearch(int[] arr, int left, int right, int findVal){
        //没有找到的情况
        if (left > right){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        int mid = (left + right) / 2;
        // 向右递归查找
        if (findVal > arr[mid]){
            return binarySearch(arr,mid+1, right, findVal);
        }
        if (findVal < arr[mid]){
            return binarySearch(arr, left, mid-1, findVal);
        }else {
            list.add(mid);
            int temp = mid-1;
            while (true){ //向左查询是否还有相同的值
                if (temp < 0){
                    break;
                }
                if (arr[temp] == arr[mid]){
                    list.add(temp);
                }
                temp --;
            }
            int temp2 = mid + 1;
            while (true){
                if (temp2 >= arr.length){
                    break;
                }
                if (arr[temp2] == arr[mid]){
                    list.add(temp2);
                }
                temp2 ++;
            }
            return list;
        }
    }
}
