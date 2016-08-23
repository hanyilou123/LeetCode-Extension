public class NumArray {
    int[] numsCopy;
    public NumArray(int[] nums) {
        numsCopy = new int[nums.length];
        for(int i=0; i<nums.length; i++)
            numsCopy[i]= nums[i];
        this.numsCopy = numsCopy;
    }

    void update(int i, int val) {
        numsCopy[i] = val;
    }

    public int sumRange(int i, int j) {
        int sum=0;
        for(int k=i; k<=j; k++)
            sum += numsCopy[k];
        return sum;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);