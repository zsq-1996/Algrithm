package com.order;

/**
 * @Pragram:ArrayQueue
 * @Description:TODO 数组模拟队列，进行插入和取值
 * @Author:ZhuShiQiang
 * @Create:2020-03-23 14:27
 **/
public class ArrayQueue {
    public static void main(String[] args) {

    }

    private int maxSize;
    //队列头
    private int front;
    //队列尾
    private int rear;
    //用于操作队列
    private int []arr;

    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;//指向队列第一个位置,a[front]不是队列的第一个元素
        rear = -1;//指向队列尾部，包含最后一个元素
    }

    //判断队列是否处于已满状态
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据
    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列已满，不能添加");
            return;
        }
        rear ++;
        arr[rear] = n;
    }

    //取数据
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，不能取数据");
        }
        front ++;//front后移
        return arr[front];
    }
    //显示数据
    public void showQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        for (int i = 0; i < arr.length; i ++){
            System.out.println(arr[i]);
        }
    }
}
