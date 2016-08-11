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
            val += rob(root.left.left, hash) + rob(root.left.right, hash);
        if(root.right!=null)
            val += rob(root.right.left, hash) + rob(root.right.right, hash);
        val = Math.max(val+root.val, rob(root.left, hash)+rob(root.right, hash));
        hash.put(root, val);
        return val;
    }
}