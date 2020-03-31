package com.order;

/**
 * @Pragram:ArrayQueue
 * @Description:TODO 数组模拟环形队列
 * @Author:ZhuShiQiang
 * @Create:2020-03-23 14:27
 **/
public class CircleArray {
    public static void main(String[] args) {

    }

    private int maxSize;
    //队列头,a[front]是队列的第一个元素,初始值为0
    private int front;
    //队列尾,指向队尾的后一个位置,初始值为0
    private int rear;
    //用于操作队列
    private int []arr;

    public CircleArray(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    //判断队列是否处于已满状态,需要考虑取模（正整数取模和取余结果一样）
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
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
        int value = arr[front];
        front = (front + 1) % maxSize;//front后移,需要考虑取模
        return value;
    }

    //求出当前队列里的有效数据个数
    public int size(){
        //rear记录了插入数据，front记录了取数据
        return (rear + maxSize - front) % maxSize ;
    }

    //显示数据
    public void showQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        for (int i = front; i < front + size(); i ++){
            System.out.printf("arr[d%]=d%\n",i % maxSize,arr[i % maxSize]);
        }
    }
}
