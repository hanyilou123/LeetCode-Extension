/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    public void buildString(TreeNode root, StringBuilder sb){
        if(root==null)
            sb.append("#").append(",");
        else
        {
            sb.append(root.val).append(",");
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> nodes = (new ArrayList<String>)(Arrays.asList(data.split(",")));
        return buildTree(nodes);
    }
    public TreeNode buildTree(List<String> nodes)
    {
        String node = nodes.remove();
        if(node.equals("#"))
            return null;
        else{
            TreeNode root = new TreeNode(Integer.parseInt(node));
            root.left = buildTree(nodes);
            root.right = buildTree(nodes);
            return root;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));