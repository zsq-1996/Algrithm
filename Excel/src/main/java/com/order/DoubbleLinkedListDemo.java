package com.order;

/**
 * @Pragram:DoubbleLinkedListDemo
 * @Description:TODO 双向链表
 * @Author:ZhuShiQiang
 * @Create:2020-03-25 10:23
 **/
public class DoubbleLinkedListDemo {

    public static void main(String[] args) {

    }
}

//
class DoubbleLinkedList{
    public HeroNode2 head = new HeroNode2(0, "", "");//头结点
    public HeroNode2 getHead(){
        return head;
    }

    //遍历链表方法
    public void showList(){
        if (head.next == null){
            return;
        }
        HeroNode2 curr = head.next;
        while (curr != null){
            System.out.println(curr);
            curr = curr.next;
        }

    }

    //add方法
    public void addNew(HeroNode2 node){
        //找到链表最后
        HeroNode2 temp = head.next;
        while (temp != null){
            temp = temp.next;//寻找下一个
        }
        temp.next = node;//将要新增的连接到最后
        node.pre = temp;//同时新增节点的pre要指向原来的最后节点，才算新增完成
    }

    //修改方法
    public void update (HeroNode2 node){
        if (head.next == null){
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (temp != null){
            if (temp.no == node.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.name = node.name;
            temp.nickName = node.nickName;
        }else {
            //没有找到的情况
            System.out.println("您想要修改的节点no不存在");
        }
    }

    //删除节点方法
    //思路：找到该节点tempNode，其next指向的节点nextNode,其pre指向的节点preNode,
    //     nextNode.pre = preNode;preNode.next = nextNode;
    public void deleteByNo(int no){
        if (head.next == null){
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (temp != null){
            if (temp.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            HeroNode2 preNode = temp.pre;
            HeroNode2 nextNode = temp.next;
            preNode.next = nextNode;
            if (nextNode != null){//如果是最后一个节点，nextNode为空，不需要下面这一步
                nextNode.pre = preNode;
            }
        }else {
            //要删除的节点不存在
            System.out.println("要删除的节点不存在");
        }
    }

    //
}

class HeroNode2{
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;//指向后一个节点
    public HeroNode2 pre;//指向前一个节点

    public HeroNode2(){}

    //构造器
    public HeroNode2(int no,String name,String nickName){
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
