package com.maze;

/**
 * @Pragram:Maze
 * @Description:TODO 迷宫问题
 * @Author:ZhuShiQiang
 * @Create:2020-03-31 13:30
 **/
public class Maze {
    public static void main(String[] args) {
        //
        int [][]map = new int[8][7];
        //1表示障碍物，开始都为0
        //设置四周一圈都为障碍物
        for (int i = 0; i < 7; i ++){
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i ++){
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置障碍物
        map [3][1] = 1;
        map [3][2] = 1;
        //打印地图
        printMap(map);
        System.out.println("原始地图=======================");
        //寻找通路
        findWay(map, 1, 1);
        printMap(map);
    }
    public static void printMap(int [][]map){
        for (int i = 0; i < 8; i ++){
            for (int j = 0; j < 7; j ++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * @Author ZhuShiQiang
     * @Description //TODO 使用递归寻找下一步
     * @Description //TODO 先定义一个策略,下->右->上->左,依次判断是否走得通,i,j表示从第几个位置开始,2表示走的通
     * @Date  2020/3/31
     * @param
     * @return
     **/
    public static boolean findWay(int [][]map, int i, int j){
        if (map[6][5] == 2){//判断最后一个位置是否可以走通,然后终止递归
            return true;
        } else {
            if (map[i][j] == 0){//这个点还没判断过
                map[i][j] = 2;//假定这个点可以通
                if (findWay(map, i+1, j)){//下
                    return true;
                }else if (findWay(map, i, j+1)){//右
                    return true;
                }else if (findWay(map, i-1, j)){//上
                    return true;
                }else if (findWay(map, i, j-1)){//左
                    return true;
                }else {
                    //说明这个点走不通
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }

        }

    }

}

