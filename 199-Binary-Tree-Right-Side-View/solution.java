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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root==null)
            return res;
        viewProcess(root, res, 0);
        return res;
    }
    public void viewProcess(TreeNode root, List<Integer> res, int height)
    {
        if(root==null)
            return;
        if(height==res.size())
        {
            res.add(root.val);
        }
        viewProcess(root.right, res, height+1);
        viewProcess(root.left, res, height+1);
    }
}