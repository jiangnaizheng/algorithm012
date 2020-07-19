import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.      
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 /*
 *思路：1.使用递归完成,时间复杂度为O(n)
 * 2.使用栈的方法完成，时间复杂度为O(n)
 */

 //使用递归来进行二叉树遍历
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>() ;
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root,List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }
}
// @lc code=end

//使用栈来进行中序遍历
class SolutionOne {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>() ;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty() ) {
            while (cur != null) {
                stack.push(cur);            //进栈
                cur = cur.left;
            }
            cur = stack.pop();             //左子树进栈完成后弹栈
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
