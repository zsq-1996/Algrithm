package com.search;

import java.util.Arrays;

/**
 * @Pragram:FibonacciSearch
 * @Description:TODO
 * @Author:ZhuShiQiang
 * @Create:2020-04-07 10:17:53
 **/
public class FibonacciSearchDemo {
    private static int maxSize = 20;
    public static void main(String[] args) {

    }

    //非递归方法获得一个Fibonacci数列
    public static int[] getFibArr(){
        int []f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i ++){
            f[i] = f[i-1] + f[i-2];
        }
        return f;
    }
    //
    public static int fibSearch(int []a, int key){
        int low = 0;
        int high = a.length - 1;
        int k = 0;//分割下标
        int mid = 0;//存放mid值
        int []f = getFibArr();
        //获取斐波那契分割下标 k
        while (high > f[k] - 1){
            k ++;
        }
        //构造新的数组指向a，f[k]作为新数组的length，所以f[k] 可能会大于 a.length，temp长度超出的部分都为0
        int []temp = Arrays.copyOf(a, f[k]);
        //temp长度超出的部分都放置a数组的最后一个位置的值
        for (int i = high +1; i < temp.length; i ++ ){
            temp[i] = a[high];
        }
        //
        while (low < high){
            mid = low + f[k-1] -1;
            if (key < temp[mid]){//向左循环查找 k-=1
                high = mid -1;
                k --;
            }else if (key > temp[mid]){//向右循环查找 k-=2 (斐波那契数列的特点)
                low = mid +1;
                k -=2;
            }else {
                if (low <= high){
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return -1;
    }
}
