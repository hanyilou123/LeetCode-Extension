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
    int minDep = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        process(root, 0);
    }
    public void process(TreeNode root, int depth)
    {
        if(root==null)
        {
            minDep = Math.min(depth, minDep);
            return;
        }
        process(root.left, depth+1);
        process(root.right, depth+1);
    }
}