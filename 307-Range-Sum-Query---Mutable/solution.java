public class NumArray {
    
    class segmentTreeNode{
        int start, end;
        segmentTreeNode left, right;
        int sum;
        public segmentTreeNode(int start, int end){
            this.start=start;
            this.end=end;
            this.left=new segmentTreeNode();
            this.right=new segmentTreeNode();
            this.sum = 0;
        }
    }
    segmentTreeNode root = null;
    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length-1);
    }
    
    public segmentTreeNode buildTree(int[] nums, int start, int end)
    {
        if(start>end)
            return null;
        else{
            segmentTreeNode ret = new segmentTreeNode(start, end);
            if(start==end)
                ret.sum = nums[start];
            else{
                int mid = start+(end-start)/2;
                ret.left = buildTree(nums, start, mid);
                ret.right = buildTree(nums, mid, end);
                ret.sum = ret.left.sum + ret.right.sum;
            }
            return ret;
        }
    }

    void update(int i, int val) {
        updateValue(root, i, val);
    }
    
    public void updateValue(segmentTreeNode root, int pos, int val)
    {
        if(root.start==root.end)
            root.sum = val;
        else{
            int mid = root.start + (root.end-root.start)/2;
            if(pos<=mid)
            {
                updateValue(root.left, pos, val);
            }
            else
            {
                updateValue(root.right, pos, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }

    public int sumRange(int i, int j) {
        return sumRandgeValue(root, i, j);
    }
    
    public int sumRandgeValue(segmentTreeNode root, int start, int end)
    {
        if(root.start==i && root.end==j)
            return root.sum;
        else{
            int mid = root.start + (root.end-root.start)/2;
            if(end<=mid)
            {
                return sumRandgeValue(root.left, start, end);
            }
            else if(start>=mid+1)
            {
                return sumRandgeValue(root.right, start, end);
            }
            else
                return sumRandgeValue(root.left, start, mid) + sumRandgeValue(root.right, mid+1, end);
        }
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);