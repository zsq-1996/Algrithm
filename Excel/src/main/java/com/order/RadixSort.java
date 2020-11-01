package com.order;

import java.util.Arrays;

/**
 * Author: Zsq
 * Description TODO: 基数排序（桶排序）
 * Time:2020/11/1 0001 下午 8:53
 */
public class RadixSort {
    public static void main(String[] args) {
        int []a = {6,3,5,8,1,9};
        radixSort(a);
        System.out.println(Arrays.toString(a));
    }
//        建立一个一维数组，每个位置对应一个桶
    //第一轮排序，
    // 将每个数的个位数取出，看这个数应该放在哪个对应的桶
    // 按照数组的下标顺序，将所有元素放回到原来的数组

    //第二轮排序，
    // 将第一轮排序后的数组的十位数取出，看这个数应该放在哪个对应的桶
    // 按照数组的下标顺序，将所有元素放回到原来的数组

    public static void radixSort(int[] arr){
        //二维数组包含十个一维数组，每个位置都是一个一维数组
        //每个一维数组的长度由需要排序的数组的长度决定
        int[][] bucket = new int[10][arr.length];
        //
        //为了记录每个桶放入了多少个数，定义一个一维数组来计数，一开始所有桶都没有元素，也就是每个位置都是0
        int[] bucketCountArr = new int[10];

        //确定数组中最大数的位数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= max){
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();
        //
        for (int m = 1,n = 1; m <= maxLength; m++, n *= 10) {
            //第一轮排序
            for (int i = 0; i < arr.length; i++) {
                //取出个位的值
                int value = arr[i] / n % 10;
                //放入到对应的桶中
                bucket[value][bucketCountArr[value]] = arr[i];
                //这个桶添加了一个元素，计数累加一次
                bucketCountArr[value] ++;
            }
            //按照桶的顺序，把桶里的数据取出来放回到原来的数组
            int index = 0;
            for (int i = 0; i < bucketCountArr.length; i++) {
                //判断桶中是否有数据
                if (bucketCountArr[i] != 0){
                    //遍历这个桶
                    for (int i1 = 0; i1 < bucketCountArr[i]; i1++) {
                        arr[index] = bucket[i][i1];
                        index ++;
                    }
                    //数据取完之后，计数用的数组归零，为之后排序重复使用
                    bucketCountArr[i] = 0;
                }
            }
            //下一轮位数往前进一位 （第一轮针对个位，第二轮针对十位，以此类推）
        }
    }

}
