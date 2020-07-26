import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
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
class Solution {
    public int minDepth(TreeNode root) {
        if (root  == null) return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }
        return min_depth + 1;
    }
}
// @lc code=end

class SolutionOne {
    public class Solution {
        public int minDepth(TreeNode root) {
            if(root == null) return 0;
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;
           
        }
    }
}

//国际站上的回答,很有趣
public static int minDepth(TreeNode root) {
	if (root == null)	return 0;
	if (root.left == null)	return minDepth(root.right) + 1;
	if (root.right == null) return minDepth(root.left) + 1;
	return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
}