package com.order;

/**
 * @Pragram:OrderDemo
 * @Description:TODO
 * @Author:ZhuShiQiang
 * @Create:2020-03-20 16:51
 **/
public class OrderDemo {

    public static void main(String[] args) {
        new OrderDemo().method1();
    }

    public void method1(){
        int []a = {6,3,5,8,1,9};
        //冒泡排序(从左往右依次比较两个相邻的元素，更大的放在靠后位置，
        //外层循环走完一次就意味着所有元素中最大的那个跑到了最后的位置；
        //外层循环走完第二次意味着剩下的所有元素中最大的那个跑到了倒数第二个位置，以此类推)
        for (int i = 0; i < a.length-1; i++){
            for (int j = 0; j < a.length-1-i; j++){
                if (a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
            //选择排序(第一次拿a[0]和后面所有元素比较，每次比较大小之后更小的放在a[0]位置，第二次用a[1]进行同样的操作，以此类推，直到最后一个比完)
//            for (int j = i+1; j < a.length; j++){
//                if (a[i]>a[j]){
//                    int temp = a[i];
//                    a[i] = a[j];
//                    a[j] = temp;
//                }
//            }
            //插入排序(每次比较后一个和前一个元素的大小，小的往前移，一直到前面没有比他更小的为止)
//            for (int j = i; j >= 0; j--){
//                if (a[j]>a[j+1]){
//                    int temp = a[j];
//                    a[j] = a[j+1];
//                    a[j+1] = temp;
//                }
//            }
        }
        for (int b: a){
            System.out.println(b);
        }
    }
}
