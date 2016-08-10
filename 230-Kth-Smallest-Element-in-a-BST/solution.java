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
    public int count =0;
    public int res=0;
    
    public int kthSmallest(TreeNode root, int k) {
        int count=0;
        countProcess(root, k);
        return res;
    }
    public void countProcess(TreeNode root, int k)
    {
        if(root.left!=null)
            countProcess(root.left, k);
        count++;
        if(count==k)
        {
            res = root.val;
            return;
        }
        if(root.right!=null)
            countProcess(root.right, k);
    }
}