package com.zhangyu.leetcoderecord.bytedance.expandExercise;

/**
 * Function: 176. 第二高的薪水
 *
 * 本题目为SQL题，答案写在main()中
 * @author zhangyu
 * Date: 2021/3/25
 * @since JDK 1.8
 */
public class Solution0176 {

    /**
     * 第二高的薪水，所以limit为1，1
     * distinct去掉重复项
     * 嵌套一层select是因为，只有这样才能在没有第二的时候返回null
     * 此外，要注意字段名称
     */
    public static void main(String[] args) {
        String sql = "select (select distinct Salary from Employee order by Salary desc limit 1,1) SecondHighestSalary;";
    }
}
