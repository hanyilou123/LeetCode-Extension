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
    public int countNodes(TreeNode root) {
        int left = countLeft(root);
        int right = countRight(root);
        if(left==right)
            return (1<<left)-1;
        else
            return 1+countNodes(root.left)+countNodes(root.right);
    }
    public int countLeft(TreeNode root)
    {
        int count = 0;
        while(root!=null)
        {
            root = root.left;
            count++;
        }
        return count;
    }
    public int countRight(TreeNode root)
    {
        int count = 0;
        while(root!=null)
        {
            root = root.right;
            count++;
        }
        return count;
    }
}