package com.sort;

/**
 * @Pragram:OrderDemo
 * @Description:TODO 冒泡排序 选择排序 插入排序 希尔排序(缩小增量排序)等
 * @Author:ZhuShiQiang
 * @Create:2020-03-20 16:51
 **/
public class BubbleSort {

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();

        //测试排序时间
//        int []a = new int[80000];
//        for (int i = 0; i < a.length; i ++){
//            a[i] = (int)(Math.random() * 80000);
//        }
//        Date date = new Date();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String timeBefore = dateFormat.format(date);
//        System.out.println("排序前的时间为：" + timeBefore);
//
//        bubbleSort.bubbleBetter(a);
//
//        Date date2 = new Date();
//        String timeafter = dateFormat.format(date2);
//        System.out.println("排序后的时间为：" + timeafter);

        //希尔排序(交换法)
//        int []a2 = {6,3,5,8,1,9};
//        bubbleSort.shellSortChange(a2);
//        printArr(a2);
        //希尔排序(移动法)
        int []a3 = {6,3,5,8,1,9};
        bubbleSort.shellSortChange(a3);
        printArr(a3);
    }
    //打印数组
    public static void printArr(int a[]){
        for (int b: a){
            System.out.print(b + " ");
        }
    }
    //冒泡排序
    public void bubbleSort(){
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
        }
    }
    //选择排序
    public void chooseSort(int a[]){
        for (int i = 0; i < a.length-1; i++){
            //选择排序(第一次拿a[0]和后面所有元素比较，每次比较大小之后更小的放在a[0]位置，第二次用a[1]进行同样的操作，以此类推，直到最后一个比完)
            for (int j = i+1; j < a.length; j++){
                if (a[i]>a[j]){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
    //插入排序
    public void insertSort(int a[]){
//        for (int i = 0; i < a.length-1; i++){
//            //插入排序(每次比较后一个和前一个元素的大小，小的往前移，一直到前面没有比他更小的为止)
//            //第一个默认有序，后面的所有元素看成一个无序列表，每次将一个元素插入到前面的有序列表中
//            //也就是有序列表的长度从1开始不断递增
//            for (int j = i; j >= 0; j--){
//                if (a[j]>a[j+1]){
//                    int temp = a[j];
//                    a[j] = a[j+1];
//                    a[j+1] = temp;
//                }
//            }
//        }
        for (int i = 1; i < a.length; i++){
            int insertValue = a[i];//保存要插入的值
            while (i >= 0 && insertValue < a[i-1]){
                a[i] = a[i-1];//把当前位置的前一个元素的值后移一位
                i --;//往前寻找,如果insertValue < a[i-1],说明还没找到要插入的位置
            }
            a[i] = insertValue;//循环结束，说明找到要插入的位置,这个时候的i就是要插入的坐标
        }
    }

    //冒泡排序(优化
    public void bubbleBetter(int arr[]){
        //冒泡排序(优化
        for (int i = 0; i < arr.length-1; i++){
            boolean flag = true;
            for (int j = 0; j < arr.length-1-i; j++){
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = false;
                }
            }
            if (flag){
                //如果没有进行一次交换，说明已经有序，没必要继续比较下去
                break;
            }
        }
    }
    //希尔排序 (缩小增量排序) 简单的插入排序存在如果后面的数较小，插入过程比较的次数就明显较多，效率也就更低的问题，
    //也是一种插入排序，是简单插入排序经过改进之后的更高效版本
    public void shellSortChange(int arr[]){
        //int group = arr.length / 2 ; 表示分组，得到步长
        //group /= 2; 步长如果大于0则继续分组
        for (int group = arr.length / 2; group > 0; group /= 2){
            for (int i = group; i < arr.length; i++){
                for (int j = i - group; j >= 0; j -= group){
                    //如果当前元素大于加上步长之后位置的元素,交换位置
                    if (arr[j] > arr[j + group]){
                        int temp = arr[j];
                        arr[j] = arr[j + group];
                        arr[j + group] = temp;
                    }
                }
            }
        }
        //分组完之后,再进行简单的插入排序
        this.chooseSort(arr);
    }
    //希尔排序 (移动法)
    public void shellSortMove(int arr[]){
        //int group = arr.length / 2 ; 表示分组，得到步长
        //group /= 2; 步长如果大于0则继续分组
        for (int group = arr.length / 2; group > 0; group /= 2){
            for (int i = group; i < arr.length; i++){
                int j = i;
                int temp = arr[j];
                if (arr[j] > arr[j - group]){
                    while (j >= 0 && temp < arr[j - group]){
                        arr[j] = arr[j - group];
                        j -= group;
                    }
                    arr[j - group] = temp;
                }
            }
        }
        //分组完之后,再进行简单的插入排序
        this.chooseSort(arr);
    }
}
