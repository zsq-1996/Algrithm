package com.listDemo;

/**
 * Author: Zsq
 * Description TODO:哈希表
 * Time:2020/4/7 0007 下午 10:11
 */
public class HashTableDemo {
    public static void main(String[] args) {
        HashTab tab = new HashTab(7);
        Emp tom = new Emp(1,"tom");
        tab.addEmp(tom);
        tab.list();
    }
}

//创建HashTable，管理多条链表
class HashTab{
    private EmpLinkedList []empLinkedList;
    private int size;
    public HashTab(int size){
        this.size = size;
        empLinkedList = new EmpLinkedList[size];
        for (int i =0; i < size; i ++){
            empLinkedList[i] = new EmpLinkedList();
        }
    }
    //散列函数,使用取模法
    public int hashMethod(int id){
        return id%size;
    }
    //
    public void addEmp(Emp emp){
        int empNo = hashMethod(emp.id);
        empLinkedList[empNo].add(emp);
    }
    //遍历所有链表
    public void list(){
        for (int i = 0; i < empLinkedList.length; i ++){
            empLinkedList[i].list();
        }
    }
}

//员工类
class Emp{
    int id;
    String name;
    Emp next;
    public Emp(int id,String name){
        this.id = id;
        this.name = name;
    }
}
//
class EmpLinkedList{
    Emp head;

    //假定增加emp时，id自增
    public void add(Emp emp){
        if (head == null){
            head = emp;
            return;
        }
        //如果不是第一个
        Emp temp = head;
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = emp;//添加到最后位置
    }

    public void list(){
        if (head == null){
            System.out.println("list is null");
            return;
        }
        Emp temp = head;
        while (true){
            System.out.printf("id = %d  name = %s",temp.id,temp.name);
            System.out.println();
            if (temp.next == null){
                return;
            }
            temp = temp.next;
        }
    }
}
