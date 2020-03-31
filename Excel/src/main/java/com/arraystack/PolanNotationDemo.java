package com.arraystack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Pragram:PolanNotation
 * @Description:TODO 波兰表达式
 * @Author:ZhuShiQiang
 * @Create:2020-03-27 13:20
 **/
public class PolanNotationDemo {
    public static void main(String[] args) {
//        String suffixExpression = "3 4 + 5 * 6 -";
//
//        System.out.println(getResult(getListString(suffixExpression)));

        //中缀表达式转换成list
        String infixExpression = "1+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(infixExpression);

        List<String> suffix = infixToSuffix(infixExpressionList);
        System.out.println(suffix);
        //后缀表达式计算获得结果
        int result = getResult(suffix);
        System.out.println(result);
    }

    //逆波兰表达式
    public String suffixExpression = "3 4 + 5 * 6 -";

    public static List<String> getListString (String suffixExpression){
        String[] eles = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for (String ele : eles){
            list.add(ele);
        }
        return list;
    }

    //
    public static int getResult(List<String> list){
        Stack<String> stack = new Stack<String>();
        for (String ele : list){
            //如果是数字，入栈，碰到运算符时从栈中弹出两个数进行运算，结果放回栈中
            if (ele.matches("\\d+")){
                stack.push(ele);
            }else {
                //弹出两个数
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int result = 0;
                if (ele.equals("-")){
                    result = num2 - num1;//先弹出的数作为减数
                }else if(ele.equals("+")){
                    result = num2 + num1;
                }else if(ele.equals("*")){
                    result = num2 * num1;
                }else if(ele.equals("/")){
                    result = num2 / num1;
                }
                stack.push(""+result);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    //中缀表达式转list
    public static List<String> toInfixExpressionList(String expression){
        List<String> strList = new ArrayList<String>();
        int index = 0;
        char c ;
        do {
            if ((c=expression.charAt(index)) < 48 || (c=expression.charAt(index)) > 57){
                //非数字的情况
                strList.add("" + c);
                index ++;
            }else {
                //如果是数字的情况,考虑是否为多位数
                String str = "";
                while (index < expression.length() && (c=expression.charAt(index)) >= 48 && (c=expression.charAt(index)) <= 57){
                    str += c;
                    index ++;
                }
                strList.add(str);
            }
        }while (index < expression.length());
        return strList;
    }

    //中缀表达式list转后缀表达式
    public static List<String> infixToSuffix(List<String> infixList){
        //定义stack
        Stack<String> stack1 = new Stack<String>();
        List<String> suffixList = new ArrayList<String>();
        //遍历
        for (String item : infixList){
            //如果是一个数
            if (item.matches("\\d+")){
                suffixList.add(item);
            }else if(item.equals("(")){
                //如果是一个左括号
                stack1.push(item);
            }else if(item.equals(")")){
                //如果是一个右括号,stack一直pop，直到碰到左括号为止(消除括号)
                while (!(stack1.peek().equals("("))){
                    suffixList.add(stack1.pop());
                }
                //弹出左括号
                stack1.pop();
            }else {
                //如果stack1栈顶的运算符优先级更高
                while (stack1.size() != 0 && OperationRank.getOperationRank(stack1.peek()) >= OperationRank.getOperationRank(item)){
                    suffixList.add(stack1.pop());
                }
                stack1.push(item);
            }
        }
        while (stack1.size() != 0){
            //将剩余的运算符添加到另一边
            suffixList.add(stack1.pop());
        }
        return suffixList;
    }
}
//判断优先级的方法
class OperationRank{
    private static final int ADD = 1;//加法
    private static final int SUB = 1;//减法
    private static final int MUL = 2;//乘法
    private static final int DIV = 2;//除法

    public static int getOperationRank(String signal){
        int rank = 0;
        switch (signal){
            case "+" :
                rank = ADD;
                break;
            case "-" :
                rank = SUB;
                break;
            case "*" :
                rank = MUL;
                break;
            case "/" :
                rank = DIV;
                break;
            default:
                break;
        }
        return rank;
    }
}
