public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        if(nums==null || nums.length==0)
            return new ArrayList<Integer>();
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        TreeNode root = new TreeNode(nums[nums.length-1]);
        root.num=1;
        list1.add(0);
        for(int i=nums.length-2; i>=0; i--)
        {
            int num = getNum(root, nums[i], 0);
            list1.add(num);
        }
        for(int i=nums.length-1; i>=0; i--)
        {
            list2.add(list1.get(i));
        }
        return list2;
    }
    public int getNum(TreeNode root, int target, int num)
    {
        if(root.val>=target)
        {
            root.num=root.num+1;
            if(root.left==null)
            {
                TreeNode node = new TreeNode(target);
                node.num=1;
                root.left = node;
                return num;
            }
            else{
                return getNum(root.left, target, num);
            }
        }
        else
        {
            num +=root.num;
            if(root.right==null)
            {
                TreeNode node = new TreeNode(target);
                node.num=1;
                root.right = node;
                return num;
            }
            else{
                return getNum(root.right, target, num);
            }
        }
    }
}
class TreeNode{
    int num;
    int val;
    TreeNode left, right;
    TreeNode(int x)
    {
        val=x;
        num=0;
    }
}