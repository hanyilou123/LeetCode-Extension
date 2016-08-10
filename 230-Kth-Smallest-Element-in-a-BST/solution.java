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
        Stack<TreeNode> st = new Stack<TreeNode>();
        while(root!=null)
        {
            st.push(root);
            root=root.left;
        }
        while(k!=0)
        {
            TreeNode temp = st.pop();
            k--;
            if(k==0)
                return temp.val;
            TreeNode right = temp.right;
            while(right!=null)
            {
                st.push(right);
                right=right.left;
            }
        }
        return -1;
    }
}