package com.skse.computer.leetcode.quene;

import org.junit.Test;

import java.lang.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author sukang
 */
public class LeetCodeQuene {


    @Test
    public void main1(){
        System.out.println(evalRPN(new String[]{
                "10","6","9","3","+","-11","*","/","*","17","+","5","+"
        }));
    }


    /**
     *根据逆波兰表示法，求表达式的值。

     有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。

     说明：
     •整数除法只保留整数部分。
     •给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。

     示例 1：
     输入: ["2", "1", "+", "3", "*"]
     输出: 9
     解释: ((2 + 1) * 3) = 9


     */

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        List<String> list = new ArrayList<String>(){{
            add("+");add("-");
            add("*");add("/");
        }};

        for (String token : tokens) {
            if (list.contains(token)){
                Integer pop = stack.pop();
                Integer pop2 = stack.pop();
                Integer result = compute(pop2,pop,token);
                stack.push(result);
            }else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }


    private Integer compute(Integer pop, Integer pop2, String token) {
        switch (token){
            case "*": return  pop * pop2;
            case "+": return  pop + pop2;
            case "-": return  pop - pop2;
            case "/": return  pop / pop2;
            default: return 0;
        }
    }


    /**
     *
     给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     ( 40   41)  {123   125}  [91  93]
     有效字符串需满足：
     1.左括号必须用相同类型的右括号闭合。
     2.左括号必须以正确的顺序闭合。
     注意空字符串可被认为是有效字符串。

     */

    public boolean isValid(String s) {

        if (s.length() % 2 != 0){ return false; }

        Stack<Byte> stack = new Stack<>();
        byte[] bytes = s.getBytes();

        for (byte aByte : bytes) {
            if (!stack.isEmpty()) {
                int i = aByte - stack.peek();
                if (i >= 1 &&  i <= 2) {
                    stack.pop();
                }else {
                    stack.push(aByte);
                }
            } else {
                stack.push(aByte);
            }
        }
        return stack.isEmpty();
    }



}
