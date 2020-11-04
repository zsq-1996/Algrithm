package com.sort;

import java.util.Arrays;

/**
 * @Pragram:RedixSort
 * @Description:TODO 基数排序(桶排序)
 * @Author:ZhuShiQiang
 * @Create:2020-04-02 12:59
 **/
public class RedixSortDemo {
    public static void main(String[] args) {
        int []arr = {53,3,542,748,14,214};
        redixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //
    public static void redixSort(int []arr){
        //得到最大数的最大位数maxLength
        int max = arr[0];
        for (int i = 1; i < arr.length; i ++){
            if (arr[i] > max){
                max = arr[i];
            }
        }
        int maxLength = String.valueOf(max).length();
        //定义一个二维数组,建立10个桶模型，0号桶，1号桶，……直到9号桶
        int [][]bucket = new int[10][arr.length];
        //定义一个数组记录每个桶放了多少个数据
        int []dataCount = new int[10];
        for (int len = 1,n = 1; len <= maxLength; len ++,n *= 10){//n=1时代表对个位进行排序，n=10时代表十位……
            //针对每个数据的个位(十位、百位……)上的数进行排序
            for (int i = 0; i < arr.length; i ++){
                int digitOfElem = arr[i] / n % 10;//digitOfElem取得是数据的个位(十位、百位……)上的数，范围在0~9
                //放到对应的桶中
                //bucket[digitOfElem][dataCount[digitOfElem]] 用个位上的数字digitOfElem作为横坐标 确定桶的位置
                //bucket[digitOfElem][dataCount[digitOfElem]] dataCount[digitOfElem]
                bucket[digitOfElem][dataCount[digitOfElem]] = arr[i];
                dataCount[digitOfElem] ++;
            }
            //第一次排序完之后，从所有桶中依次取出排序完的这些数据放到原来的arr中
            //定义一个下标索引 用于确定arr数组放数据的位置(第一个数据放在arr[0]的位置,下一个就放在arr[1])
            int index = 0;
            for (int i = 0; i < dataCount.length; i ++){
                if (dataCount[i] > 0){//桶中有数据的情况，dataCount[i]表示i号桶里面的数据个数
                    for (int j = 0; j < dataCount[i]; j ++){
                        arr[index] = bucket[i][j];
                        index ++;//arr数组填放数据的位置不断往后移
                    }
                }
                dataCount[i] = 0;//取完桶里的数据后清零
            }
        }
    }
}
