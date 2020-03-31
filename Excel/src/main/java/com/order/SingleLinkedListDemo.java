package com.order;

import java.util.Stack;

/**
 * @Pragram:SingleLinkedList
 * @Description:TODO 单链表的创建和遍历
 * @Author:ZhuShiQiang
 * @Create:2020-03-24 15:09
 **/
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode node1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode node2 = new HeroNode(2, "林冲", "豹子头");
        HeroNode node3 = new HeroNode(3, "李逵", "黑旋风");
        HeroNode node4 = new HeroNode(4, "吴用", "智多星");
        //
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.add(node1);
        linkedList.add(node2);
        linkedList.add(node3);
        linkedList.add(node4);

        //
//        linkedList.showList();
//        //
//        HeroNode node = linkedList.getNode(linkedList.head,1);
//        System.out.println(node);
        linkedList.reverseList(linkedList.head);
        linkedList.showList();
    }

}

//定义SingleLinkedList，管理HeroNode
class SingleLinkedList{


    //先定义一个头结点，头结点固定
    public HeroNode head = new HeroNode(0, "", "");

    //添加节点
    public void add(HeroNode heroNode){
        //
        HeroNode temp = head;
        //遍历链表，找到最后的节点（类似于最后的节点被包裹在最里面）
        while (true){
            if (temp.next == null){
                break;
            }
            //将temp位置后移（temp最后指向最后的节点）
            //随着循环进行，temp.next一直在变化
            temp = temp.next;
        }
        //新增的节点最后保存在链表最后的节点位置
        temp.next = heroNode;
    }

    //在指定位置添加新的节点
    public void addByOrder (HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }
            //新增的节点要插入的话，其no要按大小顺序排在已有的队伍里
            if (temp.next.no > heroNode.no){
                break;
            }else if (temp.next.no == heroNode.no){
                //已经存在，不能插入的情况
                flag = true;
                break;
            }
            //
            temp = temp.next;
        }
        if (flag){
            //已经存在，不能插入的情况
            System.out.printf("要插入的编号已存在%d\n",heroNode.no);
        }else {
            //先保存之前这个位置节点的next下一个节点信息
            heroNode.next = temp.next;
            //再把新增的节点插入到这个位置
            temp.next = heroNode;
        }
    }

    //在指定位置修改节点某些信息
    public void updateByOrder (HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }
            //找到该节点
            if (temp.no == heroNode.no){
                //已经存在，不能插入的情况
                flag = true;
                break;
            }
            //
            temp = temp.next;
        }
        if (flag){
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        }
    }

    //删除指定位置的节点
    public void deleteByNo (int no){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }
            //找到该节点
            if (temp.no == no){
                flag = true;
                break;
            }
            //
            temp = temp.next;
        }
        if (flag){
            temp.next = temp.next.next;
        }
    }

    //通过头结点获取链表节点个数
    public int getLength(HeroNode head){
        if (head.next == null){
            System.out.println("链表为空");
            return 0;
        }
        int length = 0;
        HeroNode temp = head.next;
        while (temp != null){
            length ++ ;
            temp = temp.next;
        }
        return length;
    }

    //获取链表倒数第k个节点
    public HeroNode getNode(HeroNode head , int k){
        if (head.next == null){
            System.out.println("链表为空");
            return null;
        }
        int length = getLength(head);
        if (k < 0 || k > length){
            return null;
        }
        HeroNode curr = head.next;
        for (int i = 0 ; i < length - k; i ++){
            curr = curr.next;
        }
        return curr;
    }

    //链表反转
    public void reverseList(HeroNode head){
        if (head.next == null){
            return;
        }
        HeroNode curr = head.next;
        HeroNode reverseList = new HeroNode();
        while (curr != null){
            HeroNode currNext = curr.next;//先保存当前节点下一个节点
            curr.next = reverseList.next;//当前节点插入到反转链表最前面位置
            reverseList.next = curr;//通过这一步把反转链表后面的节点串联起来
            curr = currNext;
        }
        head.next = reverseList.next;
    }

    //倒序打印遍历链表
    //思路：将链表压入栈中,利用栈的数据结构特点，先进后出
    public void reversePrint(HeroNode head){
        if (head.next == null){
            return;
        }
        HeroNode curr = head.next;
        Stack<HeroNode> stack = new Stack<>();
        while (curr != null){
            stack.push(curr);
            curr = curr.next;
        }
        while (stack.size() > 0){
            HeroNode node = stack.pop();//从stack中取出数据
            System.out.println(node);
        }
    }

    //显示链表（遍历）
    public void showList(){
        //判断链表是否为空
        if (head.next == null){
            return;
        }
        HeroNode temp = head.next;
        while (true){
            if (temp == null){
                break;
            }
            //先输出节点信息
            System.out.println(temp);
            //然后节点后移
            temp = temp.next;
        }
    }
}

//定义HeroNode，每一个对象都是一个节点
class HeroNode{
    public int no;
    public String name;
    public String nickName;
    //指向下一个节点
    public HeroNode next;

    public HeroNode(){}

    //构造器
    public HeroNode(int no,String name,String nickName){
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    //重写toString 方法
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '}';
    }
}
