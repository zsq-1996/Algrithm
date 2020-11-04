package com.search;

/**
 * Author: Zsq
 * Description TODO: 插值查找  适用于 数据量大，关键字分布均匀的情况（分布不均时，该查找方式不一定比二分查找好
 * Time:2020/11/4 0004 下午 8:11
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,28,200,3999};
        Object o = insertSearch(arr, 0, arr.length - 1, 3999);
        System.out.println(o);
    }
    //没哟找到则返回null
    public static Object insertSearch(int[] arr, int left, int right, int findVal){
        //
        System.out.println("插值查找次数~");
        if (left > right || arr[0] > findVal || findVal > arr[arr.length - 1]){
            return null;
        }
        //公式求mid值 自适应，findVal参与到了查找当中
        int mid = left + (right - left) * (findVal - arr[left])/(arr[right] - arr[left]);
        //
        int midVal = arr[mid];
        if (midVal < findVal){
            //向右递归查找
            return insertSearch(arr, mid + 1, right, findVal);
        }else if(midVal > findVal){
            //向左递归查找
            return insertSearch(arr, left, mid - 1, findVal);
        }else {
            return mid;
        }
    }
}
