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
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        return process(root);
    }
    public int process(TreeNode root)
    {
        if(root==null)
            return Integer.MAX_VALUE;
        if(root.left==null && root.right==null)
            return 1;
        return Math.min(process(root.left), process(root.right))+1;
    }
}