package com.arraystack;
/**
 * @Pragram:PolanNotation
 * @Description:TODO 八皇后问题，递归算法
 * @Author:ZhuShiQiang
 * @Create:2020-03-27 13:20
 **/
public class Queen8 {
    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.println("总计次数：" + count);
    }
    //定义一个整数，表示最大皇后数
    int max = 8 ;
    //一维数组表示棋盘
    int []array = new int[max];
    //计数器
    static int count = 0;

    //输出皇后的位置的方法
    public void print(){
        for (int i = 0; i < array.length; i ++){
            System.out.print(array[i] + " ");
        }
        System.out.println();//换行
    }

    //放置第n个皇后时，判断是否和之前的摆放位置冲突
    //n表示第n个皇后
    //array[i] == array[n]表示是否两个皇后在同一列
    //Math.abs(n-i)== Math.abs(array[n] - array[i])表示是否在同一斜线
    public boolean judge(int n){
        for (int i = 0; i < n; i ++){
            if (array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }


    public void check(int n){
        if (n == max){
            print();
            count ++;
            return;
        }
        //依次放入皇后，并判断是否冲突
        for (int i =0; i < max; i ++){
            array[n] = i;//每一行从第一列开始放置，到行末为止
            if (judge(n)){//judge(n)成立，则放置的这个皇后和前面的那些不冲突
                check(n + 1);//继续判断下一个位置（下一行从第一列开始放置，到行末为止）
            }
        }
    }
}
