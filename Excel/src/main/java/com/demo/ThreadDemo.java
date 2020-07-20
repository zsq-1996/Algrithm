package com.demo;

/**
 * @Pragram:ThreadDemo
 * @Description:TODO
 * @Author:ZhuShiQiang
 * @Create:2020-06-28 14:39:15
 **/
public class ThreadDemo {

    class MyThread extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("start myThread");
        }
    }

    class MyRunnable implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("start myRunnable");
        }
    }

    public void test1(){
        MyThread myThread = new MyThread();
        MyRunnable myRunnable = new MyRunnable();

        boolean flag = myThread.equals(myRunnable);
        int code1 = myThread.hashCode();
        int code2 = myRunnable.hashCode();
        myThread.start();
    }

    public static void main(String[] args) {
        new ThreadDemo().test1();

    }
}
