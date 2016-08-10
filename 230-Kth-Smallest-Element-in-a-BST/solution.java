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
    public int kthSmallest(TreeNode root, int k) {
        int leftNo = countProcess(root.left);
        if(leftNo>=k)
            return kthSmallest(root.left, k);
        else if(k>leftNo+1)
            return kthSmallest(root.right, k-leftNo-1);
        else
            return root.val;
    }
    public int countProcess(TreeNode root)
    {
        if(root==null)
            return 0;
        return 1+countProcess(root.left)+countProcess(root.right);
    }
}