package com.arraystack;

/**
 * @Pragram:ArrayStackDemo
 * @Description:TODO 数组模拟栈的使用
 * @Author:ZhuShiQiang
 * @Create:2020-03-25 16:41
 **/
public class ArrayStackDemo {
    public static void main(String[] args) {

    }
}

class ArrayStack{
    public int maxSize;
    public int []stack;
    public int top = -1;

    public ArrayStack(){}

    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //是否栈满
    public boolean isFull(){
        return top == maxSize -1;
    }
    //是否为空
    public boolean isEmpty(){
        return top == -1;
    }

    //入栈
    public void push(int value){
        if (isFull()){
            return;
        }
        top ++;
        stack[top] = value;
    }
    //出栈
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top --;
        return value;
    }
    //遍历
    public void showList(){
        if (isEmpty()){
            return;
        }
        for (int i = top; i >= 0; i --){
            System.out.printf("stack[%d] = %d \n",i,stack[i]);
        }
    }
}
