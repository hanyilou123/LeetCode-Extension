/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int maxValue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        processMaxPath(root);
        return maxValue;
    }
    public int processMaxPath(TreeNode root)
    {
        if(root==null)
            return 0;
        int left = Math.max(0,processMaxPath(root.left));
        int right = Math.max(0, processMaxPath(root.right));
        maxValue = Math.max(maxValue, left+right+root.val);
        return Math.max(left, right)+root.val;
    }
}