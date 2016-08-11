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
    public int rob(TreeNode root) {
        
        Map<TreeNode, Integer> hash = new HashMap<TreeNode, Integer>();
        return robSub(root, hash);
    }
    public int robSub(TreeNode root, Map<TreeNode, Integer> hash)
    {
        if(root==null)
            return 0;
        if(hash.containsKey(root))
            return hash.get(root);
        int val;
        if(root.left!=null)
            val += robSub(root.left.left, hash) + robSub(root.left.right, hash);
        if(root.right!=null)
            val += robSub(root.right.left, hash) + robSub(root.right.right, hash);
        val = Math.max(val+root.val, robSub(root.left, hash)+robSub(root.right, hash));
        hash.put(root, val);
        return val;
    }
}