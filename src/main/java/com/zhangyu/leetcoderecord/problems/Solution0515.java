package com.zhangyu.leetcoderecord.problems;


import com.zhangyu.leetcoderecord.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Function: 515. 在每个树行中找最大值
 *
 * @author zhangyu
 * Date: 2020/12/11 10:43
 * @since JDK 1.8
 */
public class Solution0515 {

    public static void main(String[] args) {
        Solution0515 solution = new Solution0515();
        TreeNode root = TreeNode.buildFromArray(new Integer[]{1, 3, 2, 5, 3, null, 9});
        System.out.println(solution.largestValues(root));
    }

    /**
     * 深度优先遍历实现
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, 0, result);
        return result;
    }

    private void helper(TreeNode root, int level, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (result.size() <= level) {
            result.add(root.val);
        } else {
            result.set(level, Math.max(root.val, result.get(level)));
        }
        helper(root.left, level + 1, result);
        helper(root.right, level + 1, result);
    }

}
