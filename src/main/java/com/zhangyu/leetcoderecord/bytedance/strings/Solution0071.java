package com.zhangyu.leetcoderecord.bytedance.strings;

import java.util.LinkedList;

/**
 * Function: 71. 简化路径
 *
 * @author zhangyu
 * Date: 2021/3/23 09:59
 * @since JDK 1.8
 */
public class Solution0071 {

    public static void main(String[] args) {
        Solution0071 solution = new Solution0071();
        System.out.println(solution.simplifyPath("/home/"));
        System.out.println(solution.simplifyPath("/../"));
        System.out.println(solution.simplifyPath("/home//foo/"));
        System.out.println(solution.simplifyPath("/a/./b/../../c/"));
        System.out.println(solution.simplifyPath("/../../../../c/"));
        System.out.println(solution.simplifyPath("/../"));
        System.out.println(solution.simplifyPath("/home//foo/"));
    }

    public String simplifyPath(String path) {
        LinkedList<String> stack = new LinkedList<>();
        for (String s : path.split("/")) {
            if (s.equals("..")) stack.poll();
            else if (!s.equals("") && !s.equals(".")) stack.push(s);
        }
        if (stack.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append("/").append(stack.pollLast());
        }
        return sb.toString();
    }

//    public String simplifyPath2(String path) {
//        LinkedList<Character> characters = new LinkedList<>();
//        characters.add('/');
//        char[] charArray = path.toCharArray();
//        for (int i = 0; i < charArray.length; i++) {
//            if (charArray[i] == '/' && characters.peek() == '/')
//                continue;
//            else if (charArray[i] == '.' && i + 1 < charArray.length && charArray[i + 1] == '.') {
//                i++;
//                if (characters.size() > 1 && characters.peek() == '/') characters.pop();
//                while (characters.size() > 1 && characters.peek() != '/') characters.pop();
//            } else if (charArray[i] == '.') {
//                continue;
//            } else {
//                characters.push(charArray[i]);
//            }
//        }
//        if (characters.size() > 1 && characters.peek() == '/') {
//            characters.pop();
//        }
//        char[] result = new char[characters.size()];
//        int index = result.length - 1;
//        while (!characters.isEmpty()) {
//            result[index--] = characters.pop();
//        }
//        return new String(result);
//    }

}
