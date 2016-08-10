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
        int count=0;
        return countProcess(root, k, count);
    }
    public int countProcess(TreeNode root, int k, int count)
    {
        if(root==null)
            return count;
        if(count==k)
            return root.val;
            
        count++;
        count = countProcess(root.left, k, count);
        count = countProcess(root.right, k, count);
    }
}