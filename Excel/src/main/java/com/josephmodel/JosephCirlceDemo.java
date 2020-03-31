package com.josephmodel;

/**
 * @Pragram:JosephCirlceDemo
 * @Description:TODO Joseph 问题模型(环形链表)
 * @Author:ZhuShiQiang
 * @Create:2020-03-25 13:24
 **/
public class JosephCirlceDemo {

    public static void main(String[] args) {
        SingleCircleLinkedList circleLinkedList = new SingleCircleLinkedList();

        circleLinkedList.addBoy(10);
        circleLinkedList.showCircle();
    }
}

//环形单项链表
class SingleCircleLinkedList{
    //创建一个first节点
    private Boy first = null;
    //添加节点
    public void addBoy(int num){
        if (num < 1){
            System.out.println("num至少为1");
            return;
        }
        Boy curr = null;
        for (int i = 1; i <= num; i ++) {
            Boy boy = new Boy(i);
            if (i == 1){
                first = boy;
                first.next = first;//构建环形
                curr = first;//curr指向第一个
            }else {//
                curr.next = boy;//以i=2为例，这一步把first指向的对象的next属性改变了，原来的环形被破坏，
                                // first指向了新增的boy，而新增的boy还没有和上一个加入的boy链接
                                //当i>=3 时，从上一个新增的boy后面断开环形，连接新增的boy
                //(也就是第二次新增是从first后面断开环形，之后都是从上一次新增的boy后面断开环形，再重新链接)
                boy.next = first;//同样以i=2为例，这一步让新增的boy和上一个新增的boy进行连接
                                //i>=3 时，让新增的boy和上一个新增的boy进行连接
                curr = boy;//curr指向最近新增的那个boy，下一次新增的时候，添加到这个的后面
            }
        }
    }
    //遍历环形链表
    public void showCircle(){
        if (first == null){
            System.out.println("circle is empty");
            return;
        }
        Boy cur = first;
        while (true){
            System.out.printf("当前的no--%d \n",cur.no);
            if (cur.next == first){
                break;
            }
            cur = cur.next;
        }
    }
    /**
     * @Author ZhuShiQiang
     * @Description //TODO 
     * @param startNo 开始的位置
     * @param count 数的次数
     * @param boyNums boy的数量
     * @return 
     **/
    public void countBoy(int startNo, int count, int boyNums){
        if (startNo < 1 || startNo > boyNums || first == null){
            System.out.println("circle is empty or startNo and other data is wrong");
            return;
        }
        //辅助指针,开始指向最后
        Boy helper = first;
        while (true){
            if (helper.next == first){
                break;
            }
            helper = helper.next;//通过循环移动到最后位置
        }
        //小孩报数前，先移动
        for (int i = 0; i < startNo - 1; i ++){
            first = first.next;
            helper = helper.next;
        }
        //
        while (true){
            if (helper == first){//当环形中只剩一个节点时
                break;
            }
            //报数count次，移动
            for (int i = 0; i < count - 1; i ++){
                first = first.next;
                helper = helper.next;//
            }
            //
            System.out.printf("要出圈的boy的no--->%d \n",first.no);
            first = first.next;
            helper.next = first;
        }
    }
}

//
class Boy{
    public int no;
    public String name;
    public Boy next;//下一个节点

    public Boy(){}

    public Boy(int no){
        this.no = no;
    }
}