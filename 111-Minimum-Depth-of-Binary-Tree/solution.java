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
        return minDep;
    }
    public void process(TreeNode root, int depth)
    {
        if(root==null)
        {
            minDep = Math.min(depth, minDep);
            return;
        }
        if(root.left==null && root.right==null)
            return 1;
        if(root.left!=null)
            process(root.left, depth+1);
        if(root.right!=null)
            process(root.right, depth+1);
    }
}